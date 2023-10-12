package com.sosow0212.with_ure;

public class 예상대진포 {

    public static int solution(int n, int a, int b) {
//        int answer = 0;
//
//        while (a != b) {
//            a = a % 2 == 0 ? a / 2 : (a + 1) / 2;
//            b = b % 2 == 0 ? b / 2 : (b + 1) / 2;
//
//            answer++;
//        }
//
//        return answer;

        int answer = 0;

        int max = Math.max(a, b);
        while (max != 1) {
            max = (max % 2 == 0 ? max : max + 1) / 2;
            answer ++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7)); // 3
    }
}
