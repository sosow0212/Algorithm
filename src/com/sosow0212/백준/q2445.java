package com.sosow0212.백준;

import java.util.Scanner;

public class q2445 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int star = scanner.nextInt();
        //상단 별찍기
        for(int i = 1 ; i <= star; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            for(int k = 2*star-i; k > 0; k--) {
                if(k>i) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        // 하단 별찍기
        for(int i = 2; i <= star; i++) {
            for(int j = i; j <= star; j++) {
                System.out.print("*");
            }
            for(int k = 1; k < i*2-1; k++) {
                System.out.print(" ");
            }
            for(int h = star; h >= i; h--) {
                System.out.print("*");
            }
            System.out.println();
        }
        scanner.close();
    }
}
