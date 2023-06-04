package 코딩기초트레이닝.day1;
import java.util.Scanner;

public class 대소문자바꿔서출력하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result ="";
        for(int i=0;i<a.length();i++)
        {
            char c = a.charAt(i);
            if((int)c<97)
            {
                result+=(char)((int)c+32);
            }
            else
            {
                result+=(char)((int)c-32);
            }
        }
        System.out.print(result);
    }
}
