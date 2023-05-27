package Chapter5_메소드;

import java.util.Arrays;

/*
 *    1. 임의의 정수 입력(배열 생성후) rand()
 *    2. 정렬 처리 arrays
 *    3. 출력 print()
 */
public class 메소드나누기_2_정렬 {
    static void rand(int[] arr)
    {
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
    	sort(arr,1);
    	sort(arr,2);
    	sort(arr,3);
    }
    static void sort(int[] arr,int a)
    {
    	int[] sort = arr;
    	String s="";
    	if(a==1)
    	{
    		s="정렬전 : \n";
    	}
    	if(a==2)
    	{
    		
    		for(int i=0;i<sort.length-1;i++)
       		{
       			for(int j=i+1;j<sort.length;j++)
       			{
       				if(sort[i]>sort[j])
       				{
       					int temp = sort[i];
       					sort[i]=sort[j];
       					sort[j]=temp;
       				}
       			}
       		}
    		s="오름차순 정렬 : \n";
    	}
    	if(a==3)
    	{
    		
    		for(int i=0;i<sort.length-1;i++)
       		{
       			for(int j=i+1;j<sort.length;j++)
       			{
       				if(sort[i]<sort[j])
       				{
       					int temp = sort[i];
       					sort[i]=sort[j];
       					sort[j]=temp;
       				}
       			}
       		}
    		s="내림차순 정렬 : \n";
    	}
    	print(s,sort);
    }
    static void print(String s,int[] arr)
    {
    	System.out.println(s+Arrays.toString(arr));
    }
	public static void main(String[] args) {
    	int[] arr = new int[5];
    	rand(arr);
    	
    	
   		
	}

}
