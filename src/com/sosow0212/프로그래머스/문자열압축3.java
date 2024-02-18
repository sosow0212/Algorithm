package com.sosow0212.프로그래머스;

public class 문자열압축3 {

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int zip = 1;
            StringBuilder result = new StringBuilder();
            String prefix = s.substring(0, i);

            for (int j = i; j <= s.length() - i; j += i) {
                String now = s.substring(j, j + i);

                if (now.equals(prefix)) {
                    zip++;
                } else {
                    if (zip > 1) {
                        result.append(zip);
                    }

                    result.append(prefix);
                    prefix = s.substring(j, j + i);
                    zip = 1;
                }
            }

            if (zip > 1) {
                result.append(zip);
            }
            result.append(prefix);
            answer = Math.min(answer, result.length() + s.length() % i);
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
