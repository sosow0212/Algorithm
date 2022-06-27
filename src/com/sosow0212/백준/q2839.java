package com.sosow0212.백준;

import java.util.Scanner;

public class q2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = 0;

        while(n >= 0) {
            if(n % 5 == 0) {
                ans += (n / 5);
                System.out.println(ans);
                return;
            }

            n -= 3;
            ans ++;
        }

        System.out.println(-1);
    }
}
