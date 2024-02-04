package com.sosow0212.프로그래머스;

public class 문자열압축 {

    public static int solution(String s) {

        int answer = Integer.MAX_VALUE;

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = "";
            int count = 1;

            for (int j = 0; j <= s.length() - i; j += i) {
                String now = s.substring(j, j + i);

                if (prev.equals(now)) {
                    count++;
                    continue;
                } else if (count > 1) {
                    sb.append(count + prev);
                    count++;
                } else {
                    sb.append(prev);
                }

                prev = now;
            }

            sb.append(count > 1 ? count + prev : prev);

            if (s.length() % i != 0) {
                sb.append(s.substring(s.length() - s.length() % i, s.length()));
            }

            answer = Math.min(answer, sb.length());
            sb = new StringBuilder();
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
