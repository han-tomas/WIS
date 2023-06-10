package 코딩기초트레이닝.day7;

public class 카운트업 {
	public int[] solution(int start, int end) {
        int[] answer = new int[end-start+1];
        int j=0;
        for(int i=start;i<=end;i++)
        {
            answer[j]=i;
            j++;
        }
        return answer;
    }
}
