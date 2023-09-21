package level_2_조건문;
import java.util.*;
public class Main9498 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        if(A>=90)
        {
            System.out.println("A");
        }
        else if(90>A && A>=80)
        {
             System.out.println("B");
        }
        else if(80>A && A>=70)
        {
             System.out.println("C");
        }
        else if(70>A && A>=60)
        {
             System.out.println("D");
        }
        else
        {
            System.out.println("F");
        }
    }
}
