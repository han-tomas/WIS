package 코딩기초트레이닝.day2;

import java.util.Scanner;

public class 홀짝구분하기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n%2==0)
        {
            System.out.println(n+" is even");
        }
        else
        {
            System.out.println(n+" is odd");
        }
        
        /*
         *  다른 풀이
         *  System.out.println(n+" is "+(n%2==0?even:odd));
         */
    }
}
