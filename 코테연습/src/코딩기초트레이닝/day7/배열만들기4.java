package 코딩기초트레이닝.day7;

import java.util.*;

public class 배열만들기4 {
	public int[] solution(int[] arr) {
		List<Integer> stk = new ArrayList<>();
		int i=0;
		while (i < arr.length) 
		{
		    if (stk.isEmpty()) {
		        stk.add(arr[i]);
		        i++;
		    } else if (stk.get(stk.size() - 1) < arr[i]) {
		        stk.add(arr[i]);
		        i++;
		    } else if (stk.get(stk.size() - 1) >= arr[i]) {
		        stk.remove(stk.size() - 1);
		    }
		}
		
		int[] result = new int[stk.size()];
		for (int j = 0; j < stk.size(); j++) {
		    result[j] = stk.get(j);
		}
		
		return result;
	}
}
