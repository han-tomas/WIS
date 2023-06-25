package 코딩기초트레이닝.day18;
/*
	문자열 myString이 주어집니다. "x"를 기준으로 해당 문자열을 잘라내 
	배열을 만든 후 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.

	단, 빈 문자열은 반환할 배열에 넣지 않습니다.
 */
import java.util.*;
public class 문자열잘라서정렬하기 {
	 public String[] solution(String myString) {
	        String[] str = myString.split("x");
	        Arrays.sort(str);
	        List<String> list = new ArrayList<String>();
	        for(String s:str)
	        {
	            if(!s.isEmpty())
	            list.add(s);
	        }
	        String[] answer = new String[list.size()];
	        for(int i =0; i<answer.length;i++)
	        {
	            answer[i]=list.get(i);
	        }
	        return answer;
	    }
}
