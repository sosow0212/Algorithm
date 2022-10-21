package com.sosow0212.프로그래머스;

class 문자열다루기기본 {
    static public boolean solution(String s) {
        boolean answer = true;

        if(s.length() == 4 || s.length() == 6) {

        } else {
            return false;
        }

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                answer = false;
            } else {
                continue;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
        System.out.println(solution("123Aa"));
        System.out.println(solution("Aa"));
        System.out.println(solution("123A"));
        System.out.println(solution("B123AB"));
    }
}
