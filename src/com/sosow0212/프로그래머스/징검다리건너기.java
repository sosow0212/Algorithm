package com.sosow0212.프로그래머스;

import java.util.Arrays;

public class 징검다리건너기 {


    public static int solution(int[] stones, int k) {
        int answer = 0;

        int[] copy = stones.clone();
        Arrays.sort(copy);

        int l = 0;
        int r = copy[copy.length - 1];

        while (l <= r) {
            int mid = (l + r) / 2;

            boolean canMove = true;

            int temp = 0;
            for (int stone : stones) {
                if (stone - mid <= 0) {
                    temp++;
                } else {
                    temp = 0;
                }

                if (temp == k) {
                    canMove = false;
                }
            }

            if (canMove) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        // 3
        System.out.println(solution(stones, k));
    }
}
