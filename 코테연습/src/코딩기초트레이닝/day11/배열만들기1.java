package 코딩기초트레이닝.day11;

public class 배열만들기1 {
	public int[] solution(int n, int k) {
        int[] answer = new int[n/k];
        int index = 0;
        for(int i =1 ; i<=n ; i++)
        {
            if(i%k==0)
            {
                answer[index]=i;
                index++;
            }
        }
        /*
	        for (int i = 1; i <= count; i++) {
	            answer[i - 1] = k * i;
	        }
         */
        return answer;
    }
}
