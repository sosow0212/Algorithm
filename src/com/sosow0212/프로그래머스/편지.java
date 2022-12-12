package com.sosow0212.프로그래머스;

public class 편지 {
    static public int solution(String message) {
        return message.length() * 2;
    }

    public static void main(String[] args) {
        System.out.println(solution("happy birthday!")); // 30
    }
}
