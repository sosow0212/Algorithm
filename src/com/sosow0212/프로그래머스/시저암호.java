package com.sosow0212.프로그래머스;

public class 시저암호 {
    static public String solution(String s, int n) {
        String answer = "";

        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (c == 32) answer += " ";
            else {
                if (c <= 90) {
                    c += n;
                    if (c > 90) c -= 26;
                } else {
                    c += n;
                    if (c > 122) c -= 26;
                }
                answer += c;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("a B z", 4)); // e F d
    }
}
