package level_2_조건문;
import java.util.*;
public class Main2753 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        if((year%4==0&&year%100!=0)|| year%400==0)
        {
            System.out.println(1);
        }
        else
        {
            System.out.println(0);
        }
    }
}
