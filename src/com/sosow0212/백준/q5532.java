package com.example.shoppingmall.web.dto;

import java.util.Scanner;

public class q5532 {

    public static double bigger(double a, double b) {
        if(a>b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) {
        int L;
        double A,B,C,D;
        Scanner scann = new Scanner(System.in);
        L=scann.nextInt();
        A=scann.nextDouble();
        B=scann.nextDouble();
        C=scann.nextDouble();
        D=scann.nextDouble();
        int homework = (int) Math.ceil(bigger(A/C,B/D));
        System.out.println(L-homework);
    }

}