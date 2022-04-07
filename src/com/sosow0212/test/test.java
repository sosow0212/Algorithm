package com.sosow0212.test;

import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        boolean Value = false;

        // 11 루트 = 3
        // 2, 3
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                Value = true;
            }
        }


        System.out.println(Value);

        // false 일 경우 소수
        // true 일 경우 소수 아님
    }
}