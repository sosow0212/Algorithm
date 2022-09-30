package com.sosow0212.프로그래머스;

public class 수박수박 {

    static public String solution(int n) {
        String answer = "";

        for (int i = 1; i <= n; i++) {

            if (i % 2 == 1) {
                answer += "수";
            } else {
                answer += "박";
            }
        }

        System.out.println(answer);

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(5)); // 수박수
    }
}
