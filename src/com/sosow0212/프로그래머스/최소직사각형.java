package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 최소직사각형 {

    public int solution(int[][] sizes) {
        int answer = 0;

        int len = sizes.length;
        int[] w = new int[len];
        int[] h = new int[len];

        for(int i=0; i<len; i++) {
            w[i] = sizes[i][0];
            h[i] = sizes[i][1];

            if(h[i] >= w[i]) {
                int temp = h[i];
                h[i] = w[i];
                w[i] = temp;
            }
        }

        Arrays.sort(w);
        Arrays.sort(h);

        answer = w[len-1] * h[len-1];


        return answer;
    }

    public static void main(String[] args) {
        최소직사각형 sol = new 최소직사각형();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(sol.solution(sizes)); // 4000
    }
}
