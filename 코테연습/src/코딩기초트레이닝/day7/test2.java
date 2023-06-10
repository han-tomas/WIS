package 코딩기초트레이닝.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test2 {

	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		List<Integer> stk = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(stk.isEmpty())
			{
				stk.add(arr[i]);
			}
			else if(stk.get(stk.size()-1)<arr[i])
			{
				stk.add(arr[i]);
			}
			else if(stk.get(stk.size()-1)>=arr[i]) 
			{
				stk.remove(stk.size()-1);
				i--;
			}
			System.out.println("i="+i+" arr["+i+"]="+arr[i]+" "+stk);
		}
		System.out.println(stk);
		
	}

}
