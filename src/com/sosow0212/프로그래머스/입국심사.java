package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 입국심사 {

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long l = 0;
        long r = (long) n * times[times.length - 1];

        while (l <= r) {
            long mid = (l + r) / 2;

            long sum = 0;
            for (int time : times) {
                sum += mid / time;
            }

            if (sum < n) {
                l = mid + 1;
            } else {
                answer = mid;
                r = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        // 28
        System.out.println(solution(n, times));
    }
}
