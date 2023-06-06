package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 숫자게임 {

    public int solution(int[] a, int[] b) {
        int answer = 0;

        // 1 3 5 7
        // 2 2 6 8
        Arrays.sort(a);
        Arrays.sort(b);
        int index = 0;

        for (int i = 0; i < b.length; i++) {
            if (a[index] >= b[i]) {
                continue;
            }
            index++;
        }

        return index;
    }

    public static void main(String[] args) {
        숫자게임 sol = new 숫자게임();

        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};

        // 3
        System.out.println(sol.solution(a, b));
    }
}
