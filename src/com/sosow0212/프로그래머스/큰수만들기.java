package com.sosow0212.프로그래머스;

public class 큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0; // 현재 위치
        int sizeOfAnswer = number.length() - k; // 뽑혀야할 수의 개수

        for (int i = 0; i < sizeOfAnswer; i++) {
            int insertValue = 0;
            for (int j = idx; j <= k + i; j++) {
                int temp = number.charAt(j) - '0';
                if (temp > insertValue) {
                    insertValue = temp;
                    idx = j + 1;
                }
            }

            answer.append(insertValue);
            if (answer.length() == sizeOfAnswer) {
                break;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4)); // 775841
    }
}
