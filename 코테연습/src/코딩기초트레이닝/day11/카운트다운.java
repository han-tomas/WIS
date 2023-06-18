package 코딩기초트레이닝.day11;
/*
		정수 start와 end가 주어질 때, 
		start에서 end까지 1씩 감소하는 수들을 
		차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 */
public class 카운트다운 {
	public int[] solution(int start, int end) {
        int[] answer = new int[start-end+1];
        int j = 0;
        for(int i=start;i>=end;i--)
        {
            answer[j]=i;
            j++;
        }
        return answer;
    }
}
