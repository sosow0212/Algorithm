package com.sosow0212.with_ure;

import java.util.Arrays;

public class 이진변환반복하기 {

    static public int[] solution(String s) {
        int tryCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }

            s = s.replaceAll("0", "");
            s = Integer.toBinaryString(s.length());
            tryCount++;
        }

        return new int[]{tryCount, zeroCount};
    }

    public static void main(String[] args) {
        // 3, 8
        System.out.println(Arrays.toString(solution("110010101001")));

        // 3,3
        System.out.println(Arrays.toString(solution("01110")));
    }
}
