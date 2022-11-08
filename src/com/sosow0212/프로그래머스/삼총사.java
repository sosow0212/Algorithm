package com.sosow0212.프로그래머스;

public class 삼총사 {
    static public int solution(int[] number) {
        int answer = 0;

        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {-2, 3, 0, 2, -5};
        System.out.println(solution(numbers));
    }
}
