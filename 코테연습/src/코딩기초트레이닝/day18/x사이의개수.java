package 코딩기초트레이닝.day18;
/*
	문자열 myString이 주어집니다. myString을 문자 "x"를 기준으로 
	나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return 
	하는 solution 함수를 완성해 주세요.
 */
import java.util.*;
public class x사이의개수 {
	public int[] solution(String myString) {
        String[] str = myString.split("x",-1);
        List<Integer> list = new ArrayList<Integer>();
		for(int i =  0; i<str.length;i++)
		{
			list.add(str[i].length());
		}
		int[] answer = new int[list.size()];
		int j=0;
		for(int i:list)
		{
			answer[j++]=i;
		}
        return answer;
    }
}
