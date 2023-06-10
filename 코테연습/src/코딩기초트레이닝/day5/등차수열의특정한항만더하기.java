package 코딩기초트레이닝.day5;

public class 등차수열의특정한항만더하기 {
	public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i = 0; i<included.length;i++)
		{
			
			if(included[i]==true)
			{
				answer+=a;
			}		
			a+=d;	
		}
        return answer;
    }
}
