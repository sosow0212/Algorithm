package com.sosow0212.프로그래머스;

public class 문자열압축 {

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String target = s.substring(0, i);
            String now = "";
            StringBuilder sb = new StringBuilder();
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                if (j + i >= s.length()) {
                    now = s.substring(j, s.length());
                } else {
                    now = s.substring(j, j + i);
                }

                if (now.equals(target)) {
                    count++;
                } else if (count == 1) {
                    sb.append(target);
                    target = now;
                } else {
                    sb.append(count);
                    sb.append(target);
                    target = now;
                    count = 1;
                }
            }

            if (i != target.length()) {
                sb.append(target);
            }

            answer = Math.min(answer, sb.toString().length());
        }

        return answer;
    }

    public static void main(String[] args) {
        // 7
        System.out.println(solution("aabbaccc"));

        // 9
        System.out.println(solution("ababcdcdababcdcd"));

        // 8
        System.out.println(solution("abcabcdede"));

        // 14
        System.out.println(solution("abcabcabcabcdededededede"));

        // 17
        System.out.println(solution("xababcdcdababcdcd"));
    }
}
