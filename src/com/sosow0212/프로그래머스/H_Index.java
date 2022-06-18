package com.sosow0212.프로그래머스;

import java.util.Arrays;


public class H_Index {
    public int solution(int[]citations){
        int answer=0;

        Arrays.sort(citations);
        // 0, 1, 3, 5, 6

        for(int i=0;i<citations.length;i++){
            int h=citations.length-i;

            if(citations[i]>=h){
                answer=h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        H_Index solution = new H_Index();
        int arr[] = {3, 0, 6, 1, 5};
        System.out.println(solution.solution(arr));
    }
}
