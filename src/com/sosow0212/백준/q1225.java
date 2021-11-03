package com.sosow0212.백준;

import java.util.Scanner;

public class q1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        int sum = 0;

        for(int i=0; i<a.length(); i++) {
            for(int j=0; j<b.length(); j++) {
                sum += Integer.parseInt(a.charAt(i) + "") * Integer.parseInt(b.charAt(j) + "");
            }
        }

        System.out.println(sum);
    }
}
