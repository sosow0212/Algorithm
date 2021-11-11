package com.sosow0212.백준;

import java.util.Scanner;

// 시간초과 에러 -> 답은 맞음

public class q11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt(); // n개의 수
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
            int sum = 0;
            int q = sc.nextInt(); // i
            int w = sc.nextInt(); // j
            // sum = a[q-i] + ~~ + a[w-1]
            if(q==w) {
                sum = a[q-1];
            }
            else {
                for(int x=q-1; x<w; x++ ) {
                    sum += a[x];
                }
            }

            System.out.println(sum);
        }
    }
}
