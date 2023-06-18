package 코딩기초트레이닝.day12;

import java.util.*;
/*
	정수 n과 정수 3개가 담긴 리스트 slicer 그리고 정수 여러 개가 담긴 리스트 num_list가 주어집니다.
	slicer에 담긴 정수를 차례대로 a, b, c라고 할 때, n에 따라 다음과 같이 num_list를 슬라이싱 하려고 합니다.

	n = 1 : num_list의 0번 인덱스부터 b번 인덱스까지
	n = 2 : num_list의 a번 인덱스부터 마지막 인덱스까지
	n = 3 : num_list의 a번 인덱스부터 b번 인덱스까지
	n = 4 : num_list의 a번 인덱스부터 b번 인덱스까지 c 간격으로
	올바르게 슬라이싱한 리스트를 return하도록 solution 함수를 완성해주세요.
 */
public class 리스트자르기 {

	public static void main(String[] args) {
		int n=3;
		int[] slicer= {1,5,2};
		int[] num_list= {1, 2, 3, 4, 5, 6, 7, 8, 9};
		List<Integer> list = new ArrayList<Integer>();
        if(n==1)
        {
            for(int i = 0; i<=slicer[1]; i++)
            {
                list.add(num_list[i]);
            }
        }
        else if(n==2)
        {
            for(int i = slicer[0]; i<num_list.length; i++)
            {
                list.add(num_list[i]);
            }
        }
        else if(n==3)
        {
            for(int i = slicer[0]; i<=slicer[1]; i++)
            {
                list.add(num_list[i]);
            }
        }
        else
        {
            for(int i = slicer[0]; i<=slicer[1]; i+=slicer[2])
            {
                list.add(num_list[i]);
            }
        }
        int[] answer= new int[list.size()];
        for(int i = 0 ; i<answer.length;i++)
        {
            answer[i]=list.get(i);
        }
        System.out.println(Arrays.toString(answer));

	}

}
