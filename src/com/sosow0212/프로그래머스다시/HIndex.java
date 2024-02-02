package com.sosow0212.프로그래머스다시;

import java.util.Arrays;

public class HIndex {

    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int l = 0;
        int r = citations[citations.length - 1];
        int max = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int temp = 0;

            for (int citation : citations) {
                if (citation >= mid) {
                    temp++;
                }
            }

            if (temp >= max) {
                max = temp;
                answer = mid;
                l++;
            } else {
                r--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = new int[]{3, 0, 6, 1, 5};

        // 3
        System.out.println(solution(citations));
    }
}
