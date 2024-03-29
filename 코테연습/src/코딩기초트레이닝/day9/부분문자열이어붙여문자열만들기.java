package 코딩기초트레이닝.day9;

import java.util.Arrays;

public class 부분문자열이어붙여문자열만들기 {
	/*
		길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다.
	 	parts[i]는 [s, e] 형태로, my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다.
	  	각 my_strings의 원소의 parts에 해당하는 부분 문자열을 순서대로 이어 붙인 문자열을
	   	return 하는 solution 함수를 작성해 주세요.
	 */
	public static void main(String[] args) {
		String answer ="";
		String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
		int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<parts.length;i++)
		{
			int s = parts[i][0];
			int e = parts[i][1];
			
			sb= sb.append(my_strings[i].substring(s,e+1));
		}
		answer = sb.toString();
		System.out.println(answer);

	}

}
