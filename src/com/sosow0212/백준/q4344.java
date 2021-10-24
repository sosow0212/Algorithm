package com.sosow0212.백준;

import java.util.Scanner;

public class q4344 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        for(int i=0; i<c; i++) {

            int n = sc.nextInt();
            int[] arr = new int[n];
            int people = 0;
            double ans = 0,  sum = 0, avg = 0;
            for(int j=0; j<n; j++) {
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            avg = sum/n;
            for(int j=0; j<n; j++) {
                if(arr[j] > avg) {
                    people ++;
                }
            }
            ans = (Math.round(n/people * 1000)/1000.0);
            System.out.println(ans + "%");
        }
    }
}
