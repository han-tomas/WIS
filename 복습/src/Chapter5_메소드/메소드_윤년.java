package Chapter5_메소드;

import java.util.Scanner;

public class 메소드_윤년 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		int year = scan.nextInt();
		
		//윤년처리
		String s = "";
		if((year%4==0 && year%100!=0)||(year%400==0))
			s="윤년입니다.";
		else
			s="윤년이 아닙니다";
		
		//출력
		System.out.println(year+"년도는 "+s);


	}

}
