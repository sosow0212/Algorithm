package com.sosow0212.leetCode;

public class q1310 {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < answer.length; i++) {
            int xorResult = 0;
            int start = queries[i][0];
            int end = queries[i][1];

            for (int j = start; j <= end; j++) {
                xorResult ^= arr[j];
            }

            answer[i] = xorResult;
        }

        return answer;
    }
}
