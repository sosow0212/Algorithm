package com.sosow0212.codility;

public class task1 {

    public int solution(int N) {
        // Implement your solution here
        // 5

        String binary = Integer.toBinaryString(N);
        int[] dp = new int[binary.length()];
        char[] arr = binary.toCharArray();

        if (arr[0] == '0' || arr[arr.length - 1] == '0') {
            return 0;
        }

        if (arr[0] == '1') {
            arr[0] = 0;
        } else {
            arr[1] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == '0') {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }

        int answer = 0;

        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        return answer;
    }

    public static void main(String[] args) {
        task1 s = new task1();

        System.out.println(s.solution(1041));
    }
}
