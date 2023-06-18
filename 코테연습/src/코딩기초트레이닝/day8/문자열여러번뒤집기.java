package 코딩기초트레이닝.day8;



public class 문자열여러번뒤집기 {

	public static void main(String[] args) {
		String my_string="rermgorpsam";
		int[][] queries= {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
		String answer="";
		StringBuilder sb = new StringBuilder(my_string);
		for(int i=0;i<queries.length;i++)
        {
            int s = queries[i][0];
            int e = queries[i][1];
            
            while(s<e) 
            {
            	char temp = sb.charAt(s);
            	sb.setCharAt(s, sb.charAt(e));
            	sb.setCharAt(e, temp);
            	s++;
            	e--;
            	
            }
        }
		answer=sb.toString();
		System.out.println(answer);

	}

}
