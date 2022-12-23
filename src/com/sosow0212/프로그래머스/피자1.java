package com.sosow0212.프로그래머스;

public class 피자1 {
    static public int solution(int n) {
        int answer = 0;
        int pizzaSlice = 7;

        if (n % 7 == 0) {
            return n / pizzaSlice;
        }

        return n / pizzaSlice + 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(15)); // 3
    }
}
