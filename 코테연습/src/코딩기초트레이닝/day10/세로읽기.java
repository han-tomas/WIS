package 코딩기초트레이닝.day10;

import java.util.Arrays;
import java.util.Spliterator;

public class 세로읽기 {

	public static void main(String[] args) {
		String my_string="ihrhbakrfpndopljhygc";
		
		int m=4;
		int c=2;
		String answer = "";
        String[] str = new String[my_string.length()/m];
        for(int i = 0; i<str.length;i++)
        {
            str[i]=my_string.substring(i*m,i*m+m);
        }
        for(int i=0;i<str.length;i++)
        {
            answer+=str[i].charAt(c-1);
        }
        System.out.println(answer);
	}

}
