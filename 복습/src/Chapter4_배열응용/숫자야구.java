package Chapter4_배열응용;
import java.util.Arrays;
import java.util.Scanner;
public class 숫자야구 {
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 컴퓨터 세개의 난수 생성 (중복 x)
		int[] com = new int[3];
		for(int i=0;i<com.length;i++)
		{
			com[i]=(int)(Math.random()*9)+1;
			for(int j=0;j<i;j++)
			{
				if(com[i]==com[j])
				{
					i--;
					break;
				}
			}
		}
//		System.out.println(Arrays.toString(com));
		
		//사용자 숫자 입력
		while(true)
		{
			System.out.print("세자리 정수 입력 : ");
			int num= scan.nextInt();
			if(num<100 || num>999)
			{
				System.out.println("세자리 정수가 아닙니다. \n다시 입력하세요.");
				continue;
			}
			//세자리 정수를 입력했다면
			int[] user = new int[3];
			user[0]=num/100; // 369/100 =>3
			user[1]=(num%100)/10; //369%100 => 69 /10 => 6
			user[2]=num%10; // 369%10 => 9
			
			// 중복된 수를 입력할 수 없다.
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				System.out.println("중복된 수는 사용 할 수 없습니다.");
				continue;
			}

			// 0을 포함 할 수 없다.
			if(user[0]==0 || user[1]==0 || user[0]==0)
			{
				System.out.println("0을 포함할 수 없습니다.");
				continue;
			}
			
			// 힌트
			int s=0,b=0;
			for(int i=0;i<com.length;i++)
			{
				for(int j=0;j<user.length;j++)
				{
					if(com[i]==user[j]) // 같은 숫자가 있는지
					{
						if(i==j)
							s++; //자리가 같은지
						else
							b++;
					}
				}
			}
			
			// 힌트 출력
			System.out.println("========");
			System.out.print("S:");
			for(int i =0;i<s;i++)
			{
				System.out.print("●");
			}
			System.out.print("\nB:");
			for(int i =0;i<b;i++)
			{
				System.out.print("●");
			}
			System.out.println("\n========");
			
			//종료
			if(s==3)
			{
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■      ■■  ■■  ■■      ■■■■      ■  ■■■  ■     ■■■■  ■  ■");
				System.out.println("■■■  ■■■■  ■■  ■■  ■■■■■■■■  ■■■■■    ■  ■  ■■■  ■■  ■  ■");
				System.out.println("■■■  ■■■■      ■■      ■■■■      ■  ■ ■  ■  ■■■  ■■  ■  ■");
				System.out.println("■■■  ■■■■  ■■  ■■  ■■■■■■■■  ■■■■■  ■■   ■  ■■■  ■■■■■■■■");
				System.out.println("■■■  ■■■■  ■■  ■■      ■■■■      ■  ■■■  ■     ■■■■  ■  ■");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				
				break;
			}
	
					
		
		}

	}

}
