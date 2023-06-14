package 코딩기초트레이닝.day11;
/*
		알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때,
		my_string에서 'A'의 개수, my_string에서 'B'의 개수,
		..., my_string에서 'Z'의 개수, my_string에서 'a'의 개수,
		my_string에서 'b'의 개수,..., my_string에서 'z'의 개수를
	    순서대로 담은 길이 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.
 */
public class 문자개수세기 {
	public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(int i = 0; i<my_string.length();i++)
        {
            char c = my_string.charAt(i);
            if(c>='A'&&c<='Z')
            {
                answer[c-'A']++;
            }
            else if(c>='a' && c<='z')
            {
                answer[c-'a'+26]++;
            }
        }
        /*
	        for (char c : myString.toCharArray()) {
	            if (c >= 'A' && c <= 'Z') { // 대문자인 경우
	                countArray[c - 'A']++;
	            } else if (c >= 'a' && c <= 'z') { // 소문자인 경우
	                countArray[c - 'a' + 26]++;
	            }
	        }
         */
        return answer;
    }	
}
