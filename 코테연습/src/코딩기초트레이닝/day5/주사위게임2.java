package 코딩기초트레이닝.day5;

public class 주사위게임2 {
	public int solution(int a, int b, int c) {
        int answer = 0;
        if(a!=b&&b!=c&&a!=c)
        {
            answer=a+b+c;
        }
        else if((a==b&&a!=c)||(b==c&&a!=b)||(a==c&&a!=b))
        {
            answer=(a+b+c)*(a*a+b*b+c*c);
        }
        else
        {
            answer=(a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c);
        }
        return answer;
    }
}
