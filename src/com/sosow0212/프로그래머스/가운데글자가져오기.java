package com.sosow0212.프로그래머스;

public class 가운데글자가져오기 {
    static public String solution(String s) {
        String answer = "";

        if(s.length() % 2 == 0) {
            // 짝
            int end = s.length() / 2;
            int start = end - 1;
            answer = s.substring(start, end + 1);
        } else {
            // 홀
            int mid = s.length() / 2;
            answer = String.valueOf(s.charAt(mid));
        }

        return answer;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "qwer";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }
}
