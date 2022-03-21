package com.sosow0212.codeUp;

import java.util.Scanner;

public class q2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];
        int minP = Integer.MAX_VALUE;
        int minJ = Integer.MAX_VALUE;

        for(int i=0; i<5; i++) {
            if(i<=2) {
                // 파스타
                arr[i] = sc.nextInt();
                minP = arr[i] < minP ? arr[i] : minP;
            } else {
                // 쥬스
                arr[i] = sc.nextInt();
                minJ = arr[i] < minJ ? arr[i] : minJ;
            }
        }

        double total = (minP + minJ) * 1.1;
        System.out.println(String.format("%.1f", total));
    }
}
