package com.sosow0212.백준;

import java.util.Scanner;

public class q19698 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int l = sc.nextInt();

        int ans = (w / l) * (h / l);
        System.out.println(Math.min(n, ans));
    }
}
