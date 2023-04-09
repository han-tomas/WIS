import java.util.Scanner;
public class 가위바위보 {
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int win =0, lose=0, draw=0, round=0; // 승 무 패 전 변수 생성후 초기화
		while(true) // 계속해서 게임 진행
		{
			// 컴퓨터 난수 생성
			int com = (int)(Math.random()*3); //0~2
			// 사용자 입력창 생성
			System.out.print("가위(0) 바위(1) 보(2)를 입력하시오. 종료(9) : ");
			int user = scan.nextInt();
			if(user==9)
			{
				System.out.println("종료");
				break;
			}
			if(user>=0 && user<=2 || user==9)
			{
				//가위(0) 바위(1) 보(2) 설정
				if(com==0)
				{
					System.out.print("com : 가위");
				}
				if(com==1)
				{
					System.out.print("com : 바위");
				}
				if(com==2)
				{
					System.out.print("com : 보");
				}
				
				System.out.print("\t"+"vs"+"\t"); // com :      vs       user:
				
				if(user==0)
				{
					System.out.println("user : 가위");
				}
				if(user==1)
				{
					System.out.println("user : 바위");
				}
				if(user==2)
				{
					System.out.println("user : 보");
				}
				
				
				/*
				 *     com     user    com-user
				 *      0       0         0    draw
				 *              1        -1    user win
				 *              2        -2    user lose
				 *              
				 *      1       0         1    user lose
				 *              1         0    draw
				 *              2        -1    user win
				 *              
				 *      2       0         2    user win
				 *              1         1    user lose
				 *              2         0    draw                 
				 */
				
				// 승패 출력
				if(com-user==-1 || com-user==2)
				{
					System.out.println("You Win !!");
					win++;
					round++;
					continue;			
				}
				else if(com-user==-2 || com-user==1)
				{
					System.out.println("You lose ...");
					lose++;
					round++;
					continue;
				}
				else
				{
					System.out.println("You lose ...");
					draw++;
					round++;
					continue;
				}
			}
			else 
			{
				System.out.println("잘못입력하였습니다. 다시 입력해주세요.");
				continue;
			}
			
			
		}
		System.out.println("=====================================");
		System.out.printf("%d전 %d승 %d무 %d패",round,win,draw,lose);
		
	}

}
