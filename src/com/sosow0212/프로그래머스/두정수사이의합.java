package com.sosow0212.프로그래머스;

class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;

        if(a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        for(int i = a; i<=b; i++) {
            answer += i;
        }

        return answer;
    }
}