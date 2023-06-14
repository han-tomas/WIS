package 코딩기초트레이닝.day11;

import java.util.Arrays;

/*
		문자열 my_string과 정수 배열 indices가 주어질 때,
		my_string에서 indices의 원소에 해당하는 인덱스의 
		글자를 지우고 이어 붙인 문자열을 return 하는 solution
		함수를 작성해 주세요.
 */
public class 글자지우기 {

	 public String solution(String my_string, int[] indices) {
	        Arrays.sort(indices);
	        StringBuilder sb = new StringBuilder(my_string);
	        for (int i = indices.length - 1; i >= 0; i--) {
	            sb.deleteCharAt(indices[i]);
	        }
	        String answer = sb.toString();
	        return answer;
	    }

}
