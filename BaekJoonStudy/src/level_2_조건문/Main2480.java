package level_2_조건문;
import java.util.*;
public class Main2480 {
	public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        if(a==b&&a==c)
        {
            System.out.println(10000+(a*1000));
        }
        else if((a==b && a!=c)||(a==c && a!=b)  )
        {
            System.out.println(1000+(a*100));
        }
        else if(b==c && b!=a)
        {
            System.out.println(1000+(b*100));
        }
        else if(a!=b && b!=c && a!=c)
        {
            int max =a;
            if(max<b)
                max=b;
            if(max<c)
                max=c;
            System.out.println(max*100);
                
        }
    }
}
