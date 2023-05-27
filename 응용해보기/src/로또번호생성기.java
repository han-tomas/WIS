
public class 로또번호생성기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = (int)(Math.random()*45)+1;
		int num2 = (int)(Math.random()*45)+1;
		int num3 = (int)(Math.random()*45)+1;
		int num4 = (int)(Math.random()*45)+1;
		int num5 = (int)(Math.random()*45)+1;
		int num6 = (int)(Math.random()*45)+1;
		
		// 중복 제거
		if(num2 == num1) {
			num2 = (int)(Math.random()*45)+1; // num2가 num1과 중복이면 num2 다시 호출
		}
		if(num3 == num1 || num3 == num2) {  
			num3 = (int)(Math.random()*45)+1; //num3이 num1, num2 중 하나와 같으면 num3을 다시 호출
		}
		if(num4 == num1 || num4 == num2 || num4 == num3) {
			num4 = (int)(Math.random()*45)+1; //num4가 num1, num2, num3 중 하나와 같으면 num4를 다시 호출
		}
		if(num5 == num1 || num5 == num2 || num5 == num3 || num5 == num4) {
			num5 = (int)(Math.random()*45)+1; //num5가 num1, num2, num3, num4 중 하나와 같으면 num5를 다시 호출
		}
		if(num6 == num1 || num6 == num2 || num6 == num3 || num6 == num4 || num6 == num5) {
			num6 = (int)(Math.random()*45)+1; //num6이 num1, num2, num3, num4, num5 중 하나와 같으면 num6를 다시 호출
		}
		
		System.out.printf("로또 번호  : %d %d %d %d %d %d \n",num1,num2,num3,num4,num5,num6);

	}
}


