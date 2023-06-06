package 코딩기초트레이닝.day3;

public class 더크게합치기 {
	public int solution(int a, int b) {
        int answer = 0;
        int ab =Integer.parseInt(String.valueOf(a)+String.valueOf(b));
		int ba =Integer.parseInt(String.valueOf(b)+String.valueOf(a));
		answer=ab>ba?ab:ba;
        return answer;
        
        /*
        다른풀이
        int answer = 0;
        int ab =Integer.parseInt(""+a+b);
		int ba =Integer.parseInt(""+b+a);
		answer=ab>ba?ab:ba;
        return answer;
        */
    }
}
