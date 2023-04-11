package Chapter5_메소드;

import java.util.Scanner;
/*
 *   메소드 
 *   1.입력 input
 *   2.2진수 처리 binary
 *   3.출력 print
 *   
 */
public class 메소드나누기_1_2진수 {
    // 입력
	static void input()
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("0~32767까지의 정수 입력 : ");
		int input = scan.nextInt();
		binary(input);
    }
	//2진수 처리
	static void binary(int num)
	{
		// 이진법 출력을 위한 16자리 배열 생성
		int[] binary = new int[16];
		// 이진법
		int index = 15;
		while(true)
		{
			binary[index]=num%2;
			num=num/2;
			if(num==0)
				break;
			index--;
		}
		print(binary);
	}
	//2진수 출력
	static void print(int[] arr)
	{
		int[] prtarr=arr;
		for(int i=0;i<prtarr.length;i++)
		{
			if(i%4==0 && i!=0)
				System.out.print(" ");
			System.out.print(prtarr[i]);
		}
	}
	public static void main(String[] args) {
		
		input();

	}

}
