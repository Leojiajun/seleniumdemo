package Test;

import java.util.Arrays;

public class TestTop3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores={89,-23,64,91,119,52,73};  
		TestTop3 TT = new TestTop3();
        System.out.println("���Գɼ���ǰ����Ϊ��");
        TT.Top3(scores);
        
        
    }
    
    //���巽����ɳɼ��������ǰ�����Ĺ���
    public void Top3(int[] scores){
        Arrays.sort(scores);
        int num=0;
        for(int i =scores.length-1;i>=0;i--){
            if (scores[i]<0 ||scores[i]>100){
                continue;
            }
            num++;
            if (num>3){
                break;
            }
        System.out.println(scores[i]);
        }
	}

}
