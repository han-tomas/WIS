package 코딩기초트레이닝.day6;
import java.util.*;
public class 마지막두원소 {

	public static void main(String[] args) {
		int[] num_list= {2, 1, 6};
		int[] answer = new int[num_list.length+1];
        for(int i=0;i<num_list.length;i++)
        {
        	answer[i]=num_list[i];
        }
        int lastnum =num_list[num_list.length-1];
        int beforenum=num_list[num_list.length-2];
        answer[num_list.length]=lastnum>beforenum?lastnum-beforenum:lastnum*2;
        System.out.println(Arrays.toString(answer));
	}

}
