package com.sosow0212.etc;

import java.util.Scanner;

public class 곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int sum = str.charAt(0) - '0';
        for (int i = 1; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if(sum <= 0 || num <= 1) {
                sum += num;
            } else {
                sum *= num;
            }
        }

        System.out.println(sum);
    }
}
