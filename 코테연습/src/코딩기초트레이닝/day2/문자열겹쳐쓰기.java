package 코딩기초트레이닝.day2;

public class 문자열겹쳐쓰기 {
 	public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String ss = my_string.substring(0, s)+overwrite_string;
		answer= ss+my_string.substring(ss.length());
        return answer;
    }
}
