package 코딩기초트레이닝.day12;

import java.util.*;

/*
	정수 배열 arr가 주어집니다. 배열 안의 2가 모두 포함된 가장 
	작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요.

	단, arr에 2가 없는 경우 [-1]을 return 합니다.
 */
public class 숫자2의영역 {
	public int[] solution(int[] arr) {
        int first = -1;
        int last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                first = i;
                break;
            }
        }
        if (first != -1) {
            for (int i = first; i < arr.length; i++) {
                if (arr[i] == 2) {
                    last = i;
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        if (first == -1) {
            list.add(-1);
        } else if (first== last) {
            list.add(2);
        } else {
            for (int i = first; i <= last; i++) {
            list.add(arr[i]);
            }        
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
