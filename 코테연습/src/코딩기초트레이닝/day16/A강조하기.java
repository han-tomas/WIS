package 코딩기초트레이닝.day16;
/*
	문자열 myString이 주어집니다. myString에서 알파벳 "a"가 등장하면 전부 "A"로 변환하고, 
	"A"가 아닌 모든 대문자 알파벳은 소문자 알파벳으로 변환하여 return 하는 solution 함수를 완성하세요.
 */
public class A강조하기 {
	 public String solution(String myString) {
	        StringBuilder answer = new StringBuilder(myString.toLowerCase());
	        for (int i = 0; i < answer.length(); i++)
	        {
	            if (answer.charAt(i) == 'a') 
	            {
	                answer.setCharAt(i, 'A');
	            } 

	        }
	        return answer.toString();
	    }
	    /*
	        public String solution(String myString) {
	            myString = myString.toLowerCase();
	            myString = myString.replace('a', 'A');

	            return myString;
	        }
	    */
}
