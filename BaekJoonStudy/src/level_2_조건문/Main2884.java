package level_2_조건문;
import java.util.*;
public class Main2884 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int M = scan.nextInt();
        if((M-45)>=0)
        {
            System.out.println(H+" "+(M-45));
        }
        else
        {
            if((H-1)<0)
            {
                System.out.println(23+" "+(15+M));
            }
            else
            {
                System.out.println((H-1)+" "+(15+M));
            }
        }
    }
}
