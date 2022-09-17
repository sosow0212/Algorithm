package com.sosow0212.프로그래머스;

import java.util.List;

public class 숫자의표현 {

    public boolean success(int pos, int n) {
        int sum = 0;
        for(int i=pos; i<=n; i++) {
            sum += i;
            if(sum == n) {
                return true;
            } else if(sum > n) {
                return false;
            }
        }
        return false;
    }


    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++) {
            if(success(i, n)) {
                answer ++;
                continue;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        숫자의표현 sol = new 숫자의표현();
        System.out.println(sol.solution(15)); // 4
    }
}
