package com.sosow0212.백준;

import java.util.*;

public class q3046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int s = sc.nextInt();
        int ans = 0;

        ans = (s*2) - a;

        System.out.println(ans);
    }
}
