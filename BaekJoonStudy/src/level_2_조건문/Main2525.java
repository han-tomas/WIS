package level_2_조건문;
import java.util.*;
public class Main2525 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        if(B+C>=60)
        {
            if((A+((B+C)/60))>=24)
               System.out.println(((A+((B+C)/60))-24)+" "+((B+C)%60));
            else   
                System.out.println((A+((B+C)/60))+" "+((B+C)%60));
        }    
        else
        {
            System.out.println(A+" "+(B+C));
        }
        
    }
}
