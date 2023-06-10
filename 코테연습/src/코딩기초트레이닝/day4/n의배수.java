package 코딩기초트레이닝.day4;

public class n의배수 {
	public int solution(int num, int n) {
        int answer = 0;
        answer=num%n==0?1:0;
        return answer;
    }
}
