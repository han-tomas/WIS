package 코딩기초트레이닝.day13;
/*
	정수 리스트 num_list와 정수 n이 주어질 때, num_list의 첫 번째 원소부터
	n 번째 원소까지의 모든 원소를 담은 리스트를 return하도록 
	solution 함수를 완성해주세요.
 */
import java.util.*;
public class n번째원소까지 {
	 public int[] solution(int[] num_list, int n) {
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i = 0; i<=n-1; i++ )
	        {
	            list.add(num_list[i]);
	        }
	        int[] answer = new int[list.size()];
	        for(int i = 0; i<answer.length;i++)
	        {
	            answer[i]=list.get(i);
	        }
	        return answer;
	        /*
		        public int[] solution(int[] num_list, int n) {
			        int[] answer = new int[n];
		
			        for(int i=0; i<n;i++){
			            answer[i] = num_list[i];
			        }
			        return answer;
		    	}
	        */
	    }
}
