package com.sosow0212.백준;

import java.util.Scanner;

public class q9625 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int strt = 0;
        int calculateA = 1;// A는 B로 B는 AB로
        int calculateB = 0;
        int tmp;
        while (strt != K) {
            tmp = calculateA;
            calculateA = calculateB;
            calculateB += tmp;

            strt++;
        }

        System.out.println(calculateA + " " + calculateB);
    }
}