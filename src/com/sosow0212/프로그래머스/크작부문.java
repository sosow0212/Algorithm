package com.sosow0212.프로그래머스;

public class 크작부문 {

    public static int solution(String t, String p) {
        int answer = 0;
        int length = p.length();
        long num = Long.parseLong(p);

        for (int i = 0; i < t.length() - length + 1; i++) {
            String sub = t.substring(i, i + length);
            if (Long.parseLong(sub) <= num) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // 8
        System.out.println(solution(
                "500220839878", "7"
        ));
    }
}
