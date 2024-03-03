package com.sosow0212.프로그래머스다시;

public class 큰수만들기 {

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int answerLength = number.length() - k;
        int index = 0;

        for (int i = 0; i < answerLength; i++) {
            int max = 0;

            for (int j = index; j <= i + k; j++) {
                if (number.charAt(j) - '0' > max) {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }

            answer.append(max);

            if (answer.length() == answerLength) {
                break;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        // 775841
        System.out.println(solution("4177252841", 4));
    }
}
