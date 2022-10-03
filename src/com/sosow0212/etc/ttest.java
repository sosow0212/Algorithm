package com.sosow0212.etc;

import java.util.Scanner;

public class ttest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();

            if (str.isBlank()) {
                break;
            }

            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i);
                System.out.println(Integer.toHexString(c));
            }

            System.out.println("d");
            System.out.println("a");
        }
    }
}
