package com.sosow0212.프로그래머스;

public class 콜라츠추측 {
    static public int solution(int n) {
        long num = n;
        int count = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            count++;

            if (count > 500) {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(6)); // 8
    }
}
