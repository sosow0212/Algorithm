package com.sosow0212.프로그래머스;

public class q1 {

    static int solution(int price, int money, int count) {
        int answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += (price * i);
        }

        return Math.abs(answer - money);
    }

    public static void main(String[] args) {
        // 10
        System.out.println(solution(3, 20, 4));
    }
}
