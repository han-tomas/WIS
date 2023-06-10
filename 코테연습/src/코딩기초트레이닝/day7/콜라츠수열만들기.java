package 코딩기초트레이닝.day7;

import java.util.*;

public class 콜라츠수열만들기 {
	public int[] solution(int n) {
        List<Integer> list = new ArrayList<Integer>();
		list.add(n);
        while(n!=1)
        {
            if(n%2==0)
            {
                n/=2;
                list.add(n);
            }
            else
            {
                n=n*3+1;
                list.add(n);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
