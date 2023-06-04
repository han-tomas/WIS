package 프로그래머스.lv1;

import java.util.Scanner;

public class 짝수와홀수 {

	    public static String solution(int num) {
	        String answer = "";
	        if(num%2==0)
	        answer="Even";
	        else
	        answer="Odd";
	        return answer;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = scan.nextInt();
		String s = solution(num);
		System.out.println(s);
	}
	

}
