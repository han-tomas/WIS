package 코딩기초트레이닝.day11;
/*
	정수 start와 end가 주어질 때,
	 start에서 end까지 1씩 감소하는 
	 수들을 차례로 담은 리스트를 return하도록
	  solution 함수를 완성해주세요.
 */
public class 가까운1찾기 {
	public static int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
   }
}
