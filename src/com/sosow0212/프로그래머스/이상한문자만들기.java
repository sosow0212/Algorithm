package com.sosow0212.프로그래머스;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        String[] arr = s.split("");

        for (String str : arr) {
            cnt = str.contains(" ") ? 0 : cnt + 1;
            answer += cnt % 2 == 0 ? str.toLowerCase() : str.toUpperCase();
        }

        return answer;
    }

    public static void main(String[] args) {
        이상한문자만들기 sol = new 이상한문자만들기();

        String s = "try hello worl";
        System.out.println(sol.solution(s));
    }
}