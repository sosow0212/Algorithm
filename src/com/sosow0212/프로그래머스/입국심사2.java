package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 입국심사2 {

    public static long solution(int n, int[] times) {
        // 이분탐색
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long l = 0;
        long r = (long) times[times.length - 1] * n;

        while (l <= r) {
            long temp = 0;
            long mid = (l + r) / 2;

            for (int time : times) {
                temp += mid / time;
            }

            if (temp < n) {
                l = mid + 1;
            } else {
                answer = mid;
                r = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 28
        System.out.println(solution(6, new int[]{7, 10}));
    }
}
