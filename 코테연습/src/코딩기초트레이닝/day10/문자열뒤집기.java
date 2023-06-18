package 코딩기초트레이닝.day10;
/*
		문자열 my_string과 정수 s, e가 매개변수로 주어질 때,
		my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을
		return 하는 solution 함수를 작성해 주세요.
 */
public class 문자열뒤집기 {
	public String solution(String my_string, int s, int e) {
        String answer = "";
        StringBuilder sb = new StringBuilder(my_string);
        while(s<e)
        {
            char temp=sb.charAt(s);
            sb.setCharAt(s,sb.charAt(e));
            sb.setCharAt(e,temp);
            s++;
            e--;
        }
        answer=sb.toString();
        return answer;
    }
}
