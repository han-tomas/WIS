package 코딩기초트레이닝.day9;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] intStrsStrings = {"0123456789","9876543210","9999999999999"};
		int s = 5; 
		int l = 5;
		for(int i = 0; i<intStrsStrings.length;i++)
		{
			System.out.println(Integer.parseInt(intStrsStrings[i].substring(s, s+l)));
		}
	}

}
