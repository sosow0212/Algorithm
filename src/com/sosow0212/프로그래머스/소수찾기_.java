package com.sosow0212.프로그래머스;

public class 소수찾기_ {

    static int answer;

    static public int solution(int n) {
        answer = 0;

        for(int i=2; i<=n; i++) {
            if(isPrime(i)) {
                answer ++;
            } else {
                continue;
            }
        }

        return answer;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(10)); // 4
    }
}
