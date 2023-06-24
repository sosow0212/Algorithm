package com.sosow0212.프로그래머스;

public class 큰수만들기2 {
    public static String solution(String number, int k) {
        int lengthOfNumber = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < lengthOfNumber; i++) {
            int max = 0;

            for (int j = index; j <= k + i; j++) {
                int numberOfIndex = number.charAt(j) - '0';

                if (numberOfIndex > max) {
                    max = numberOfIndex;
                    index = j + 1;
                }
            }

            sb.append(max);
            if(sb.length() == lengthOfNumber) {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("4177252841", 4)); // 775841
    }
}
