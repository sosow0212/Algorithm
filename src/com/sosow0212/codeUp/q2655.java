package com.sosow0212.codeUp;

import java.util.Scanner;

public class q2655 {
    public static void main(String[] args) {
        // y = ax + b
        // x = -b / a

        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double result = -b/a;

        System.out.println(Math.round(result * 100000)/100000.0);
    }
}
