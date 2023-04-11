package Chapter4_배열응용;
import java.util.Arrays;

public class 로또번호생성 {
 
	public static void main(String[] args) {
        // 6칸 배열 확정
		int[] arr = new int[6];
		for(int i=0; i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*45)+1; //6개 난수 출력
			for(int j=0;j<i;j++)              
			{
				/*
				 *  i=0
				 *  i=1 j=0
				 *  i=2 j=0,1
				 *  i=3 j=0,1,2
				 *  i=4 j=0,1,2,3
				 *  i=5 j=0,1,2,3,4
				 */
				if(arr[i]==arr[j])
				{
					i--;    // 중복이면 해당 index번호에 다시 난수를 만들기 위해서
					break; // for(int j=0;j<i;j++) 반복문을 벗어남
					
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
