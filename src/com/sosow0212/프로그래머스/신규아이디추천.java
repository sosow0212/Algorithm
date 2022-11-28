package com.sosow0212.프로그래머스;

public class 신규아이디추천 {
    static public String solution(String new_id) {
        String answer = "";

        // 1단계
        String str = new_id.toLowerCase();

        // 2단계
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if ((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9') || a == '-' || a == '_' || a == '.') {
                answer += a;
            }
        }

        // 3단계
        while (true) {
            if (!answer.contains("..")) {
                break;
            }
            answer = answer.replace("..", ".");
        }

        // 4단계
        while (true) {
            if (answer.length() == 0) {
                break;
            }
            if (answer.charAt(0) != '.' && answer.charAt(answer.length() - 1) != '.') {
                break;
            }

            if (answer.charAt(0) == '.') {
                answer = answer.substring(1);
            }

            if (answer.length() != 0) {
                if (answer.charAt(answer.length() - 1) == '.') {
                    answer = answer.substring(0, answer.length() - 1);
                }
            }
        }

        // 5단계
        if (answer.equals("")) {
            answer += "a";
        }

        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            while (true) {
                if (answer.charAt(answer.length() - 1) != '.') {
                    break;
                }
                answer = answer.substring(0, answer.length() - 1);
            }
        }

        // 7단계
        if (answer.length() <= 2) {
            while (true) {
                if (answer.length() == 3) {
                    break;
                }

                char c = answer.charAt(answer.length() - 1);
                answer += c;
            }
        }

        return answer;
    }
}
