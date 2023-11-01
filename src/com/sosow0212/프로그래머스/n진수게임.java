package com.sosow0212.프로그래머스;

public class n진수게임 {

    public static String solution(int n, int t, int m, int p) {
        StringBuilder numbers = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        // 진법 n,
        // 미리 구할 숫자의 갯수 t,
        // 게임에 참가하는 인원 m, (5, 2)
        // 튜브의 순서 p 가 주어진다.

        for (int i = 0; numbers.length() <= t * m; i++) {
            numbers.append(parse(i, n));
        }

        for (int i = p - 1; answer.length() < t; i += m) {
            answer.append(numbers.charAt(i));
        }

        return answer.toString().toUpperCase();
    }

    static String parse(int number, int n) {
        return Integer.toString(number, n);
    }

    public static void main(String[] args) {
        // 0111
        System.out.println(solution(2, 4, 2, 1));

        // 02468ACE11111111
        System.out.println(solution(16, 16, 2, 1));

        // 13579BDF01234567
        System.out.println(solution(16, 16, 2, 2));
    }
}
