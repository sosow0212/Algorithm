package com.sosow0212.백준;

import java.util.Scanner;

public class q1543 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String doc = s.nextLine();
        String str = s.nextLine();

        int cnt = 0;

        for (int i = 0; i < doc.length() - str.length() + 1; i++) {

            if (doc.substring(i, i + str.length()).equals(str)) {
                cnt++;
                i += str.length();
                i--;
            } else
                continue;
        }


        System.out.println(cnt);
    }
}