package 코딩기초트레이닝.day8;

public class 주사위게임3 {
	/*
		1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다. 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.

		 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
		세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서 나온 숫자가
		q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
		주사위가 두 개씩 같은 값이 나오고, 나온 숫자를 각각 p, q(p ≠ q)라고 한다면
		(p + q) × |p - q|점을 얻습니다.
		어느 두 주사위에서 나온 숫자가 p로 같고 나머지 두 주사위에서
		나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
		네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중 가장 작은 숫자 만큼의 점수를 얻습니다.
		네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때,
		얻는 점수를 return 하는 solution 함수를 작성해 주세요.
	 */
	public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        if(a==b&&a==c&&a==d)
        {
            int p =a;
            answer=p*1111;
        }
        else if(a==b&&a==c&& a!=d)
        {
            int p = a;
            int q = d;
            answer=(int)Math.pow((10*p+q),2);
        }
        else if(a==b&&a==d&& a!=c)
        {
            int p=a;
            int q=c;
            answer=(int)Math.pow((10*p+q),2);
        }
        else if(a==d&&a==c && a!=b)
        {
            int p = a;
            int q = b;
            answer=(int)Math.pow((10*p+q),2);
        }
        else if(d==b&&d==c&& a!=d)
        {
            int p = a;
            int q = d;
            answer=(int)Math.pow((10*p+q),2);
        }  
        else if (a == b && c == d && a != c) 
        {
            int p= a;
            int q = c;
            answer = (p + q) * (int)Math.abs(p - q);
        } 
        else if (a == c && b == d && a != b) 
        {
            int p= a;
            int q = b;
            answer = (p + q) * (int)Math.abs(p - q);
        }
        else if (a == d && b == c && a != b) 
        {
            int p= a;
            int q = b;
            answer = (p + q) * (int)Math.abs(p - q);
        }
        else if(a==b && a!=c && a!=d)
        {
            int q=c;
            int r=d;
            answer=q*r;        
        }
        else if(a==c && a!=b && a!=d)
        {
            int q=b;
            int r=d;
            answer=q*r;        
        }
        else if(a==d && a!=c && a!=b)
        {
            int q=c;
            int r=b;
            answer=q*r;        
        }
        else if(a!=b&&a!=c&&a!=d)
        {
            int min=7;
            if(min>a)
            {
                min=a;
            }
            if(min>b)
            {
                min=b;
            }
            if(min>c)
            {
                min=c;
            }
            if(min>d)
            {
                min=d;
            }
            
            answer=min;
        }
        return (int)answer;
    }
	/*
	public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        if(a == b && b == c && c == d) 
        {
            answer = 1111 * a;
        }
        else if(a == b && b == c) {
            answer = (int) Math.pow((10*a+d),2);
        }
        else if(a == d && d == c) {
            answer = (int) Math.pow((10*a+b),2);
        }
        else if(b == d && d == c) {
            answer = (int) Math.pow((10*d+a),2);
        }
        else if(a == d && d == b) {
            answer = (int) Math.pow((10*a+c),2);
        }
        else if(a == b && c == d) {
            answer = (a + c) * Math.abs(a -c);
        }
        else if(a == c && b == d) {
            answer = (a + b) * Math.abs(a -b);
        }
        else if(a == d && c == b) {
            answer = (a + c) * Math.abs(a -c);
        }
        else if( a == b && a != c && a != d && c!=d) {
            answer = c*d;
        }
        else if( a == c && a != b && a != d && b!=d) {
            answer = b*d;
        }
        else if( a == d && a != b && a != c && b!=c) {
            answer = b*c;
        }
        else if( b == c && b != a && b != d && a!=d) {
            answer = a*d;
        }
        else if( b == d && b != a && b != c && a!=c) {
            answer = a*c;
        }
        else if( c == d && c != b && c != a && a!=b) {
            answer = a*b;      
        }
        else
        {
            int min=6;
            if(min>=a)
            {
                min=a;
            }
            if(min>=b)
            {
                min=b;
            }
            if(min>=c)
            {
                min=c;
            }
            if(min>=d)
            {
                min=d;
            }
            
            answer=min;
        }
        return answer;
    } 
	 */
}
