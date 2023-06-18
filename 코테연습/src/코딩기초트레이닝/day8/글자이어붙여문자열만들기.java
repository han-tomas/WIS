package 코딩기초트레이닝.day8;

public class 글자이어붙여문자열만들기 {

	public static void main(String[] args) {
		int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
		String my_string="cvsgiorszzzmrpaqpe";
		String answer="";
		for(int i:index_list)
		{
			answer+=my_string.charAt(i);
		}
		System.out.println(answer);

	}

}
