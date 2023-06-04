package 프로그래머스.lv1;

import java.util.Scanner;

public class 자릿수더하기 {
	 public static int solution(int n) {
	        int answer = 0;
	        while(n>0)
	        {
	            answer+=n%10;
	            n/=10;
	        }
	        return answer;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int n = scan.nextInt();
		int result = solution(n);
		System.out.println("각 자리수 합:"+result);
		

	}

}
