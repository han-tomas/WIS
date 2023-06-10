package 코딩기초트레이닝.day5;

public class 코드처리하기 {
	public String solution(String code) {
        String answer = "";
        int mode =0;
        for(int i = 0; i<code.length(); i++)
        {
            if(mode==0)
            {
                if(code.charAt(i)!='1')
                {
                    if(i%2==0)
                        answer+=code.charAt(i);
                }
                else
                {
                    mode=1;
                }
            }
            else if(mode==1)
            {
                if(code.charAt(i)!='1')
                {
                    if(i%2==1)
                        answer+=code.charAt(i);
                }
                else
                {
                    mode=0;
                }
            }        
        }
        if(answer.length()==0)
        {
            answer="EMPTY";
        }
             return answer;
           
    }
}
