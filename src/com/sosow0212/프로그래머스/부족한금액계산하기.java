package com.sosow0212.프로그래머스;

public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }

        if (sum > money) {
            answer = sum - money;
        } else {
            answer = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        부족한금액계산하기 sol = new 부족한금액계산하기();
        System.out.println(sol.solution(3, 20, 4));
    }
}
