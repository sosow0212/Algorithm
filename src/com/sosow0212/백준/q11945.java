package com.sosow0212.백준;

import java.util.Scanner;

public class q11945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String ans = "";
            String str = sc.next();
            for (int j = str.length() - 1; j >= 0; j--) {
                ans += str.charAt(j);
            }
            System.out.println(ans);
        }
    }
}
