package com.sosow0212.leetCode;

import java.util.Arrays;

public class q1653 {

    public int minimumDeletions(String s) {
        int answer = Integer.MAX_VALUE;
        int aCount = 0;
        int bCount = 0;
        int[] arrA = new int[s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            arrA[i] = aCount;

            if (s.charAt(i) == 'a') {
                aCount++;
            }
        }

        System.out.println(Arrays.toString(arrA));

        for (int i = 0; i < s.length(); i++) {
            answer = Math.min(answer, arrA[i] + bCount);

            if (s.charAt(i) == 'b') {
                bCount++;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        q1653 sol = new q1653();

        // 2
        System.out.println(sol.minimumDeletions("aababbab"));
    }
}
