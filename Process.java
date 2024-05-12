
class ProcessData {
	
    public int arriveTime;
    
    public int serviceTime;
    
    public int finishTime;
    
    public int turnTime;
   
 

    public ProcessData(int arriveTime, int serviceTime) {
        this.arriveTime = arriveTime;
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() {
        return arriveTime + "\t" +
                serviceTime + "\t" +
                finishTime + "\t" +
                turnTime ;
               
    }
}
public class Process {
    
    public static double avgTotalTime;// ƽ����ת��ʱ��
    
   

    public static void main(String[] args) {
        ProcessData[] processData = new ProcessData[4];

        // �����ĸ�����
        processData[0] = new ProcessData(0, 20); // ����0
        processData[1] = new ProcessData(5, 15); // ����1
        processData[2] = new ProcessData(10, 5); // ����2
        processData[3] = new ProcessData(15, 10); // ����3
        
        SJF(processData);
    }

   
    private static void SJF(ProcessData[] processData) {
        int preFinished = 0; // ǰһ�����̵����ʱ�伴��һ�����̵Ŀ�ʼʱ��
        avgTotalTime = 0;    // ƽ����תʱ��
        

        for (int i = 0; i < processData.length; i++) {
            processData[i].finishTime = 0; // �������ʱ��Ϊ0
            processData[i].turnTime = 0; //   ������תʱ��Ϊ0
           
        }

        int number = 0;  // ����������
        // ����˫��forѭ�����ڱȽϽ��̵����ʱ�������ʱ��
        for (int i = 0; i < processData.length; i++) {
            int min = 10000;
            for (int j = 0; j < processData.length; j++) {
               
                if (processData[j].serviceTime < min && processData[j].arriveTime <= preFinished && processData[j].finishTime == 0) {
                    min = processData[j].serviceTime; // ��Ŀǰ����ʱ����̵Ľ��̵�����ʱ�丳ֵ�����̵���С���ʱ��
                    number = j; // ����һ�����е��ȵĽ�����Ÿ�ֵ��number
                }
            }
            processData[number].finishTime = preFinished + processData[number].serviceTime;  // ��ǰ���̵����ʱ�������һ�����̵����ʱ��ӵ�ǰ���̵�����ʱ��
            preFinished = processData[number].finishTime; // ����һ�����̵����ʱ�丳ֵΪ��ǰ���̵����ʱ��
            processData[number].turnTime = processData[number].finishTime - processData[number].arriveTime;  // ��תʱ�� = ���ʱ�� - ����ʱ��
           
        }
        System.out.println("����ҵ�����㷨��");
        Display(processData);
    }
	
    private static void Display(ProcessData[] processData) {
        System.out.println("����ʱ��\t" + "����ʱ��\t" + "���ʱ��\t" + "��תʱ��\t" );
        for (int i = 0; i < processData.length; i++) {
            System.out.println(processData[i]);
            avgTotalTime += processData[i].turnTime; // ������תʱ�䣬��ʱavgTotalTime�д洢��ֵΪ����תʱ��
            
        }

        avgTotalTime = avgTotalTime / processData.length; // ƽ����תʱ��
       

        System.out.println("ƽ����תʱ�䣺" + avgTotalTime);
       
    }
}

