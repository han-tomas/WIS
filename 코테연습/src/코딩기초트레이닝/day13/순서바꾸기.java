package 코딩기초트레이닝.day13;
/*
	정수 리스트 num_list와 정수 n이 주어질 때, num_list를 n 번째 
	원소 이후의 원소들과 n 번째까지의 원소들로 나눠 n 번째 원소 이후의 
	원소들을 n 번째까지의 원소들 앞에 붙인 리스트를 return하도록 
	solution 함수를 완성해주세요.
 */
public class 순서바꾸기 {
	public int[] solution(int[] num_list, int n) {
        int idx = 0;
        int[] answer = new int[num_list.length];
        for (int i = n;i < num_list.length;i++)
            answer[idx++] = num_list[i];
        for (int i = 0;i < n;i++)
            answer[idx++] = num_list[i];
        return answer;
    }
    /*
	    public int[] solution(int[] num_list, int n) {
	        int[] answer = new int[num_list.length];
	        System.arraycopy(num_list, n, answer, 0, num_list.length - n);
	        System.arraycopy(num_list, 0, answer, num_list.length - n, n);
	        return answer;
	        
	         System.arraycopy(복사할 원본 배열, 원본 배열에서 복사를 시작할 인덱스, 
	                            복사된 요소들을 저장할 대상 배열, 대상 배열에서 복사된 요소들이 저장될 시작 인덱스,
	                            복사할 요소의 개수);
	
	         
	    }
    */
}
