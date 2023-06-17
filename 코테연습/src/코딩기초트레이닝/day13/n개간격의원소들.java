package 코딩기초트레이닝.day13;
import java.util.*;
public class n개간격의원소들 {
	public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<num_list.length;i+=n)
        {
            list.add(num_list[i]);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length;i++)
        {
            answer[i]=list.get(i);
        }
        return answer;
    }  
}
