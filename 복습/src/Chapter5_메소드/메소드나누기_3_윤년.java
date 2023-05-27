package Chapter5_메소드;

import java.util.Scanner;
/*
 *    1. 년도 입력 input
 *    2. 윤년 처리 yearCheck
 *    3. 출력 print
 */
public class 메소드나누기_3_윤년 {
    static int input() 
    {
    	Scanner scan = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		return scan.nextInt();
		
    }
    static String yearCheck(int year)
    {
    	
    	String s="";
		if((year%4==0 && year%100!=0)||(year%400==0))
			s="윤년입니다.";
		else
			s="윤년이 아닙니다";
		
		return s;
    }
    static void print(int year,String s)
    {
    	System.out.println(year+"년도는 "+s);
    }
    static void process()
    {
    	int year = input();
    	String s=yearCheck(year);
    	print(year,s);
    	
    }
	public static void main(String[] args) {
		process();

	}

}
