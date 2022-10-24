package com.sosow0212.프로그래머스;

public class 배열의평균값 {
    static public double solution(int[] numbers) {
        double answer = 0;

        for(int i=0; i<numbers.length; i++) {
            answer += numbers[i];
        }

        answer /= numbers.length;
        return answer;
    }

    public static void main(String[] args) {

    }
}
