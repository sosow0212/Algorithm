package com.sosow0212.프로그래머스;

public class 피보나치수 {
    public int solution(int n) {
        int answer = 0;

        int a = 1;
        int b = 1;

        for (int i = 3; i <= n; i++) {
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        피보나치수 sol = new 피보나치수();
        System.out.println(sol.solution(100000)); // 2
    }
}
