package com.sosow0212.leetCode;

import java.util.Arrays;

public class q2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        // 1 3 5
        // 2 4 7

        // 1 2 3 6
        // 1 4 5 9

        Arrays.sort(seats);
        Arrays.sort(students);

        int answer = 0;

        for (int i = 0; i < seats.length; i++) {
            answer += Math.abs(seats[i] - students[i]);
        }

        return answer;
    }
}
