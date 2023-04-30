package Chapter5_메소드;

import java.util.Arrays;

public class 메소드_정렬 {

	public static void main(String[] args) {
		//임의의 난수 입력 받기
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
			for(int j=0;j<i;j++) // 중복 없애기
			{
				if(arr[i]==arr[j])
				{
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		// 정렬 (Select)
		// ASC
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		// DESC
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		
		

	}

}
