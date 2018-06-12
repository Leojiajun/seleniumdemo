package Test;

import java.util.Arrays;

public class TestTop3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores={89,-23,64,91,119,52,73};  
		TestTop3 TT = new TestTop3();
        System.out.println("考试成绩的前三名为：");
        TT.Top3(scores);
        
        
    }
    
    //定义方法完成成绩排序并输出前三名的功能
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
