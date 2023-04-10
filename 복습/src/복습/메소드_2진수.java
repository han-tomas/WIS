package 복습;
import java.util.Scanner;
public class 메소드_2진수 {

	// 정수 입력 메소드
	static void process()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("0~32767까지의 정수 입력 : ");
		int num = scan.nextInt();
		
		//출력
		int[] arr2= binary(num);

		for(int i=0;i<arr2.length;i++)
			{
				if(i%4==0 && i!=0)
					System.out.print(" ");
				System.out.print(arr2[i]);
			}
			
	}
	//이진법처리 메소드
	static int[] binary(int input)
	{
		int[] arr = new int[16];
		int index = 15;
		while(true)
		{
			arr[index]=input%2;
			input=input/2;
			if(input==0)
				break;
			index--;
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		// 정수 입력
//		Scanner scan = new Scanner(System.in);
//		System.out.println("0~32767까지의 정수 입력 : ");
//		int input = scan.nextInt();
//		
//		//이진법 처리
//		/*
//		 *    ex) 100  ==> 1   1  0 0 1 0 0
//		 *                 64 32 16 8 4 2 1            
//		 *        
//		 *        2|100 ...0
//		 *         ----
//		 *        2| 50 ...0
//		 *         ----
//		 *        2| 25 ...1
//		 *         ----
//		 *        2| 12 ...0
//		 *         ----
//		 *        2|  6 ...0
//		 *         ----
//		 *        2|  3 ...1
//		 *         ----
//		 *            1 
//		 *         
//		 *          
//		 */
//		// 이진법 출력을 위한 16자리 배열 생성
//		int[] arr = new int[16];
//		// 이진법
//		int index = 15;
//		while(true)
//		{
//			arr[index]=input%2;
//			input=input/2;
//			if(input==0)
//				break;
//			index--;
//		}
//		// 이진수 출력
//		for(int i=0;i<arr.length;i++)
//		{
//			if(index%4==0)
//				System.out.println(" ");
//			System.out.println(arr[i]);
//		}
		process();

	}

}
