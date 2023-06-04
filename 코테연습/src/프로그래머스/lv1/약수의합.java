package 프로그래머스.lv1;

import java.util.*;

public class 약수의합 {

    public static int solution(int n) {
        int answer = 0;
        for(int i=1;i<=n;i++)
        {
            if(n%i==0)
            {
                answer+=i;
            }
        }
        return answer;
    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자입력 : ");
		int n = scan.nextInt();
		int total = solution(n);
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				list.add(i);
			}
		}
		System.out.println(n+"의 약수는 "+list+"이고 그 합은 "+total+"입니다");
		
	}

}
