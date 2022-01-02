package com.sosow0212.백준;

import java.util.Scanner;

public class q2711 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=0; i<t; i++) {
            int n = sc.nextInt() - 1;
            String word = sc.next();

            for(int j=0; j<word.length(); j++) {
                if(j == n) {
                    continue;
                }
                System.out.print(word.charAt(j));
            }
            System.out.println();
        }
    }
}
