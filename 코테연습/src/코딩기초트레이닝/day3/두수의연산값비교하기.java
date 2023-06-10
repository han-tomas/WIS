package 코딩기초트레이닝.day3;

public class 두수의연산값비교하기 {

	public int solution(int a, int b) {
        int answer = 0;
        int ab = Integer.parseInt(""+a+b);
		answer = ab>2*a*b?ab:2*a*b;
        return answer;
    }

}
