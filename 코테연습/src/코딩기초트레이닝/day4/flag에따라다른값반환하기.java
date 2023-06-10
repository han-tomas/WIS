package 코딩기초트레이닝.day4;

public class flag에따라다른값반환하기 {
	public int solution(int a, int b, boolean flag) {
        int answer = 0;
        answer=flag?a+b:a-b;
        return answer;
    }
}
