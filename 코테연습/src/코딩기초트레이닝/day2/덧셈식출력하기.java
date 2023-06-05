package 코딩기초트레이닝.day2;

import java.util.Scanner;

public class 덧셈식출력하기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.printf("%d + %d = %d",a,b,a+b);
	}
}
