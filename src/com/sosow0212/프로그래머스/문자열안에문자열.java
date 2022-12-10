package com.sosow0212.프로그래머스;

public class 문자열안에문자열 {
    static public int solution(String str1, String str2) {
        if(str1.contains(str2))
            return 1;
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdefg", "abc")); // 1
    }
}
