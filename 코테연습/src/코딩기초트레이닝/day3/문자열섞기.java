package 코딩기초트레이닝.day3;

public class 문자열섞기 {
	 public String solution(String str1, String str2) {
	        String answer = "";
	        String sumString = str1+str2;
	        for(int i=0;i<sumString.length();i++)
	        {
	            if(i%2==0)
	            {
	                answer+=str1.charAt(i/2);
	            }
	            else
	            {
	                answer+=str2.charAt(i/2);
	            }
	        }
	        return answer;
	        // 다른 풀이
	        /*
	        String answer="";
			for(int i = 0; i<str1.length();i++)
		    {
		    	answer+=str1.charAt(i);
		    	answer+=str2.charAt(i);
		    }
			return answer
			*/
	}

}
