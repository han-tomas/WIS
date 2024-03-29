package 코딩기초트레이닝.day19;
/*
	0과 1로만 이루어진 정수 배열 arr가 주어집니다. arr를 이용해 새로운 배열 stk을 만드려고 합니다.

	i의 초기값을 0으로 설정하고 i가 arr의 길이보다 작으면 다음을 반복합니다.
	
	만약 stk이 빈 배열이라면 arr[i]를 stk에 추가하고 i에 1을 더합니다.
	stk에 원소가 있고, stk의 마지막 원소가 arr[i]와 같으면 stk의 마지막 원소를 stk에서 제거하고 i에 1을 더합니다.
	stk에 원소가 있는데 stk의 마지막 원소가 arr[i]와 다르면 stk의 맨 마지막에 arr[i]를 추가하고 i에 1을 더합니다.
	위 작업을 마친 후 만들어진 stk을 return 하는 solution 함수를 완성해 주세요.
	
	단, 만약 빈 배열을 return 해야한다면 [-1]을 return 합니다.
 */
import java.util.*;
public class 배열만들기6 {
	 public int[] solution(int[] arr) {
	        List<Integer> list = new ArrayList<Integer>();
	        for(int i = 0;i<arr.length;i++)
	        {
	            if(list.size()==0)
	            {
	                list.add(arr[i]);
	            }
	            else
	            {
	                if(arr[i]==list.get(list.size()-1))
	                {
	                    list.remove(list.size()-1);
	                }
	                else
	                {
	                    list.add(arr[i]);
	                }
	            }
	        }
	        if(list.size()==0)
	        {
	            list.add(-1);
	        }
	        int[] answer = new int[list.size()];
	        for(int i=0;i<answer.length;i++)
	        {
	            answer[i]=list.get(i);
	        }
	        return answer;
	    }
}
