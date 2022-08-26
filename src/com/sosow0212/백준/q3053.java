package com.sosow0212.백준;

import java.util.Scanner;

public class q3053 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        double pi = 3.14159265359;

        double u = pi * r * r;
        double t = r * r * 2;

        System.out.println(u);
        System.out.println(t);

    }
}
