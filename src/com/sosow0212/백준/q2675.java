package com.sosow0212.백준;

import java.util.Scanner;

public class q2675 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0; i<t; i++) { // T 케이스만큼 반복
            int count = sc.nextInt(); // 반복할 문자의 수
            String str = sc.next();

            for(int j=0; j<str.length(); j++) { // 반복
                for(int m=0; m<count; m++) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println("");
        }
    }
}
