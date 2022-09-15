package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.Collections;

public class 최솟값만들기 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length -1 -i];
        }

        return answer;
    }

    public static void main(String[] args) {
        최솟값만들기 sol = new 최솟값만들기();
        int[] a = {1, 4, 2};
        int[] b = {5, 4, 4};
        System.out.println(sol.solution(a, b)); // 29
    }
}
