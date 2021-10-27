package com.sosow0212.백준;

import java.util.Scanner;

public class q1159 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] name = new String[n];
        int count[] = new int[26];
        int output = 0;

        for (int i = 0; i < n; i++) {
            name[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            output = (int) (name[i].charAt(0)) - 97;
            count[output]++;
        }

        boolean res = true;

        for(int i=0; i<count.length; i++) {
            if (count[i] >= 5) {
                res = false;
                System.out.print((char) (i + 97) + "");
            }
        }
        if(res)
            System.out.println("PREDAJA");
    }
}
