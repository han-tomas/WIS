package 코딩기초트레이닝.day6;

public class 수조작하기1 {
	public int solution(int n, String control) {
        for(int i = 0; i<control.length(); i++)
        {
            if(control.charAt(i)=='w')
                n+=1;
            else if(control.charAt(i)=='s')
                n-=1;
            else if(control.charAt(i)=='d')
                n+=10;
            else if(control.charAt(i)=='a')
                n-=10;
        }
        return n;
        /* 다른 풀이
        int answer = n;

        for(char ch : control.toCharArray()) {
            switch(ch) {
                case 'w': answer += 1; break;
                case 's': answer -= 1; break;
                case 'd': answer += 10; break;
                case 'a': answer -= 10; break;
                default:break;
            }
        }

        return answer;
        */
    }
}
