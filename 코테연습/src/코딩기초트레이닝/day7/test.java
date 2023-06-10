package 코딩기초트레이닝.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {

	public static void main(String[] args) {
		int n = 10;
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
        System.out.println(Arrays.toString(answer));
	}

}
