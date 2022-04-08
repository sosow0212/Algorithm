package com.sosow0212.백준;

import java.util.Scanner;

public class q4096 {

    public static boolean isPal(int n) {
        String nStr = Integer.toString(n);
        String palStr = "";

        for (int i = nStr.length() - 1; i >= 0; i--) {
            palStr += nStr.charAt(i);
        }

        if (nStr.equals(palStr)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 1;
        while (true) {
            n = sc.nextInt();

            if (n == 0) {
                break;
            }

            for (int i = 0; ; i++) {
                n += i;
                if (isPal(n)) {
                    System.out.println(n);
                    break;
                }
            }


        }
    }
}