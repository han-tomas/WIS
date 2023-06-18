package 코딩기초트레이닝.day8;

public class 숫자9로나눈나머지 {
	public static void main(String[] args) {
		String number="78720646226947352489";
		 int answer = 0;
	        int total= 0;
	        for(int i = 0; i<number.length();i++)
	        {
	            total+=number.charAt(i)-'0';
	        }
	        answer=total%9;
	        System.out.println(answer);
	}
}
