package level_2_조건문;
import java.util.*;
public class Main1330 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        if(A>B){
            System.out.println(">");
        }
        else if(A<B){
            System.out.println("<");
        }
        else if(A==B){
            System.out.println("==");
        }
    }
}
