package com.sosow0212.백준;

import java.util.Scanner;

public class q12852 {
    public static int[] d = new int[1000];
    public static int[] s = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        for(int i=2; i<=x; i++) {
            // 1을 빼는 경우
            d[i] = d[i-1] + 1;

            // 2로 나눠지는 경우
            if(i%2 == 0)
                d[i] = Math.min(d[i], d[i/2] + 1);

            if(i%3 == 0)
                d[i] = Math.min(d[i], d[i/3] + 1);
        }

        System.out.println(d[x]);
    }
}
