package com.sosow0212.백준;

import java.util.Scanner;

public class q25372 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            String str = sc.next();
            int count = str.length();

            if(count >= 6 && count <= 9) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
