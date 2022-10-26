package com.sosow0212.woowa;

import java.util.*;

public class woowa2 {

    public static void main(String[] args) {
        System.out.println(solution("browoanoommnaon"));
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        // 중복 문자열 제거 메서드 실행
        answer = delete(cryptogram);
        return answer;
    }


    public static String delete(String cryptogram) {
        while (true) {
            if (isLengthZero(cryptogram) || isNotMoreDelete(cryptogram)) {
                break;
            }

            cryptogram = deleteChar(cryptogram);
        }

        return cryptogram;
    }


    public static boolean isLengthZero(String cryptogram) {
        boolean isLengthZero = cryptogram.length() == 0 ? true : false;
        return isLengthZero;
    }


    public static boolean isNotMoreDelete(String cryptogram) {
        boolean isNotMoreDelete = true;

        for (int i = 1; i < cryptogram.length(); i++) {
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                isNotMoreDelete = false;
            }
        }

        return isNotMoreDelete;
    }


    public static String deleteChar(String cryptogram) {
        List<Integer> deleteIndexOfCharAt = new ArrayList<>(); // 중복이 여러개 될 수 있으므로 (3연속 중복 등)
        StringBuilder sb = new StringBuilder(cryptogram);
        StringBuilder result = new StringBuilder();

        // 3개의 문자가 연속으로 올 수도 있음!
        for (int i = 1; i < sb.length(); i++) {
            char now = sb.charAt(i);
            if (now == sb.charAt(i - 1)) {
                deleteIndexOfCharAt.add(i - 1);
                deleteIndexOfCharAt.add(i);
            }
        }

        for (int i = 0; i < cryptogram.length(); i++) {
            if (!deleteIndexOfCharAt.contains(i)) {
                result.append(cryptogram.charAt(i));
            }
        }

        return result.toString();
    }


}
