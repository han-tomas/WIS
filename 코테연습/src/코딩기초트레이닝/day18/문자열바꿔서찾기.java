package 코딩기초트레이닝.day18;
/*
	문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다. 
	myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분 
	문자열 중 pat이 있으면 1을 아니면 0을 return 하는 solution 함수를 완성하세요.
 */
public class 문자열바꿔서찾기 {
	public int solution(String myString, String pat) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(myString);
		for(int i=0;i<myString.length();i++)
		{
			if(sb.charAt(i)=='A')
			
				sb.setCharAt(i, 'B');	
			else
				sb.setCharAt(i, 'A');
		}
		myString=sb.toString();
		if(myString.contains(pat))
		{
			answer=1;
		}
		else
			answer=0;
        return answer;
    }
}
