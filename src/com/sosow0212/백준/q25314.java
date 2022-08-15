package com.sosow0212.백준;

import java.util.Scanner;

public class q25314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String ans = "";

        ans = "long ".repeat(n/4) + "int";
        System.out.println(ans);
    }
}
