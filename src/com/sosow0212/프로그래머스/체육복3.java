package com.sosow0212.프로그래머스;

public class 체육복3 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] arr = new int[n + 2];

        for (int i : lost) {
            arr[i]--;
        }

        for (int i : reserve) {
            arr[i]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 1) {
                if (arr[i - 1] == -1) {
                    arr[i - 1]++;
                    arr[i]--;
                } else if (arr[i + 1] == -1) {
                    arr[i + 1]++;
                    arr[i]--;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] >= 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 5
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }
}
