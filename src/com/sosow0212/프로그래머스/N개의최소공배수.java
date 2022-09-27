package com.sosow0212.프로그래머스;

public class N개의최소공배수 {
    static public int solution(int[] arr) {
        int answer = 0;
        return getLCM(arr);

    }

    public static int getLCM(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }

        return lcm;
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 6, 8, 14})); // 168
    }
}
