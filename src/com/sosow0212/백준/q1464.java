package com.sosow0212.백준;

import java.util.Scanner;

public class q1464 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String temp = str.substring(0, 1);

        // 사전 반대 순으로 먼저 나열
        for (int i = 1; i < str.length(); i++) {
            if (temp.charAt(i - 1) < str.charAt(i)) {
                temp = str.charAt(i) + temp;
            } else {
                temp = temp + str.charAt(i);
            }
        }

        // 문자열 뒤집어서 사전 순으로 나열 (== 정답)
        String ans = "";
        for (int i = temp.length() - 1; i >= 0; i--) {
            ans += temp.charAt(i);
        }

        System.out.println(ans);
    }

}
