package com.sosow0212.프로그래머스;

public class JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");
        boolean flag = true;

        for (String str : arr) {
            answer += flag ? str.toUpperCase() : str;
            flag = str.equals(" ") ? true : false;
        }

        return answer;
    }

    public static void main(String[] args) {
        JadenCase문자열만들기 sol = new JadenCase문자열만들기();
        System.out.println(sol.solution("3pe  ople unFollowed me  1"));
    }
}
