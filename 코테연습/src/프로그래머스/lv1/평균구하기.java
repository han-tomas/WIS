package 프로그래머스.lv1;

public class 평균구하기 {
	public static double solution(int[] arr) {
        double answer = 0;
        int total = 0;
        
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        
        answer = (double) total / arr.length;
        return answer;
    }	
	
    public static void main (String[] args)
    {
        int[] arr1 = {1, 2, 3, 4}; 
        double d = solution(arr1);
        System.out.printf("%.1f\n", d);
        int[] arr2 = {5,5};
        d=solution(arr2);
        System.out.printf("%.1f\n", d);
        
    }
}
