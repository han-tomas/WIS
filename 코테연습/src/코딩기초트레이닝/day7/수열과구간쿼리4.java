package 코딩기초트레이닝.day7;

public class 수열과구간쿼리4 {
	public int[] solution(int[] arr, int[][] queries) {
        /* 내 풀이
        int[] answer = arr; // 복제가 아니기 때문에 answer값이 바뀌면 arr값도 바뀐다.
        for(int i = 0; i<queries.length;i++)
        {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            for(int j = s;j <= e;j++)
            {
                if(j%k==0)
                {
                    answer[j]=arr[j]+1;
                }
            }
        }
        return answer;
        */
		int[] answer =arr.clone(); // clone()으로 복제를 하면, arr과 answer은 독립적
        for(int i = 0; i<queries.length;i++)
        {
            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];
            
            for(int j = s;j <= e;j++)
            {
                if(j%k==0)
                {
//                  answer[j]=arr[j]+1; // arr은 계속 0,1,2,4,5
                	answer[j]+=1;
                }
            }
        }
        return answer;
    }
}
