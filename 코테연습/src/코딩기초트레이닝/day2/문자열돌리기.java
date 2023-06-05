package 코딩기초트레이닝.day2;

import java.util.Scanner;

public class 문자열돌리기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i= 0;i<a.length();i++)
        {
            char c = a.charAt(i);
            System.out.println(c);
        }
    }
}
