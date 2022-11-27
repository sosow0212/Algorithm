package com.sosow0212.프로그래머스;

public class 공던지기 {
    static public int solution(int[] numbers, int k) {
        int answer = 0;

        for (int i = 0; i < k - 1; i++) {
            answer += 2;
            if (answer > numbers.length - 1) {
                answer -= numbers.length;
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int k = 2;
        System.out.println(solution(numbers, k)); // 3
    }
}
