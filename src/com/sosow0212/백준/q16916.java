package com.sosow0212.백준;

import java.util.Scanner;

public class q16916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String com = sc.next();

        if(str.contains(com)) {
            System.out.println(1);
            return;
        } else {
            System.out.println(0);
            return;
        }
    }
}
