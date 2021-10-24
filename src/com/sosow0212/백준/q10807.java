package com.sosow0212.백준;

import java.util.Scanner;

public class q10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = sc.nextInt();

        for(int i=0; i<n; i++) {
            if(ans == arr[i]) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
