package com.sosow0212.with_ure;

public class 점프순간이동 {

    public static int solution(int n) {
        int answer = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                answer++;
                n -= 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 2
        System.out.println(solution(5));

        // 2
        System.out.println(solution(6));

        // 5
        System.out.println(solution(5000));
    }
}
