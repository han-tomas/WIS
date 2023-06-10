package 코딩기초트레이닝.day6;

import java.util.Arrays;

public class 수열과구간쿼리3 {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4};
		int[][] queries= {{0, 3},{1, 2},{1, 4}};
		for (int[] query : queries) {
        	System.out.println(Arrays.toString(query));
            int temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        }
	}
}
