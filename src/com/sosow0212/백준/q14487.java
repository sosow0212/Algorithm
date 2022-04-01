package com.sosow0212.백준;

import java.util.Scanner;

public class q14487 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 0;
        int sum = 0;
        int arr[] = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
            max = arr[i] > max ? arr[i] : max;
        }
        System.out.println(sum - max);

    }
}
