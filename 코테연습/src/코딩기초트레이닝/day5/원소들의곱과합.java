package 코딩기초트레이닝.day5;

public class 원소들의곱과합 {
	public int solution(int[] num_list) {
        int answer = 0;
        int multi =1;
        int sum=0;
        for(int i=0;i<num_list.length;i++)
        {
            multi*=num_list[i];
            sum+=num_list[i];
        }
        return answer=multi<sum*sum?1:0;
//      return answer=multi<Math.pow(sum, 2)?1:0;   //=> Math.pow(num,2) : 제곱
    }
}
