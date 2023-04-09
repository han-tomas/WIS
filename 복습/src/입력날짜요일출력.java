import java.util.Scanner;
public class 입력날짜요일출력 {
 
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("년도를 입력하시오 : ");
		int year = scan.nextInt();
		System.out.print("월을 입력하시오 : ");
		int month = scan.nextInt();
		System.out.print("일을 입력하시오 : ");
		int day = scan.nextInt();
		
		//요일
		char[] strWeek = {'일','월','화','수','목','금','토'};
		//각 달에 마지막 날
		int[] lastDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		if((year%4==0&&year%100!=0)||year%400==0)
		{
			lastDay[1]=29;
		}
		else
			lastDay[1]=28;
		
		// ex)2023년 04월 09일
		// 입련 년도 전년도까지의 일수 합 => 1~2022년 12월 31일 
		int total = (year-1)*365
				+ (year-1)/4
				-(year-1)/100
				+(year-1)/400;
		
		//입력 전달까지의 합 => 1월~3월31일
		for(int i =0;i<month-1;i++)
		{
			total+=lastDay[i];
		}
		
		// 입력 날짜합 => 4월 1일~ 4월9일
		total+=day;
		
		//요일 출력
		System.out.printf("%d년도 %d월 %d일은 %c요일 입니다. ",year,month,day,strWeek[total%7]);
		

	}

}
