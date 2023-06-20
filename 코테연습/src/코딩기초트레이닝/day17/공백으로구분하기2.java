package 코딩기초트레이닝.day17;
/*
	단어가 공백 한 개 이상으로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때, 
	my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 
	return 하는 solution 함수를 작성해 주세요.
 */
import java.util.*;
public class 공백으로구분하기2 {
	public String[] solution(String my_string) {
        List<String> list = new ArrayList<String>();
        String[] str = my_string.split(" ");
        for(int i=0;i<str.length;i++)
        {
            if(!str[i].equals(""))
                list.add(str[i]);
        }
        String[] answer= new String[list.size()];
        for(int i =0;i<answer.length;i++)
        {
            answer[i]=list.get(i);
        }
        return answer;
    }
}
