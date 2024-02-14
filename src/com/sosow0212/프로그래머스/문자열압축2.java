package com.sosow0212.프로그래머스;

public class 문자열압축2 {

    public static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            int zip = 1;
            StringBuilder after = new StringBuilder();
            String pattern = s.substring(0, i);

            for (int j = i; j <= s.length() - i; j += i) {
                String next = s.substring(j, j + i);

                if (pattern.equals(next)) {
                    zip++;
                } else {
                    if (zip > 1) {
                        after.append(zip);
                    }

                    after.append(pattern);
                    pattern = s.substring(j, j + i);
                    zip = 1;
                }
            }

            if (zip > 1) {
                after.append(zip);
            }
            after.append(pattern);

            answer = Math.min(answer, after.length() + s.length() % i);
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
