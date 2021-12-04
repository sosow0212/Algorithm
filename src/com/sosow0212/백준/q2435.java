package com.sosow0212.백준;

import java.util.Scanner;

public class q2435 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        for(int i=0; i<k; i++) {
            sum += arr[i];
        }

        int max = sum;
        for(int i=k; i<n; i++) {
            sum += arr[i];
            sum -= arr[i-k];
            if(max < sum)
                max=sum;
        }
        System.out.println(max);

    }
}
