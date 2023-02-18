package com.sosow0212.백준;

import java.util.Scanner;

public class q27294 {

    private static final int SMALLER = 280;
    private static final int LAGER = 320;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int s = sc.nextInt();

        if(s == 1) {
            System.out.println(SMALLER);
        } else {
            if(t <= 11) {
                // 아침 술 x
                System.out.println(SMALLER);
            } else if (t >= 12 && t <= 16) {
                // 점심 술 x
                System.out.println(LAGER);
            } else {
                // 저녁 술 x
                System.out.println(SMALLER);
            }
        }
    }
}
