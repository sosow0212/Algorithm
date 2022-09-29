package com.sosow0212.test;

import java.util.Scanner;

// 백준 2003 투포인터 연습문제
public class two_pointer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = 0;
        int end = 0;
        int sum = 0;
        int ans = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 투 포인터 시작
        while(true) {
            for(int i=start; i<=end; i++) {
                sum += i;
            }
            if(sum > m) {
                start --;
            } else if (sum < m) {
                end ++;
            } else{
                ans ++;
            }
        }
    }
}
