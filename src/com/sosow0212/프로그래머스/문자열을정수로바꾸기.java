package com.sosow0212.프로그래머스;

public class 문자열을정수로바꾸기 {
    static public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("-10"));
    }
}
