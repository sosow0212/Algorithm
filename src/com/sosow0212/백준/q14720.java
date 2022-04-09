package com.sosow0212.백준;

import java.util.Scanner;

public class q14720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int count = 0;
        int per = 0;

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            if(per == arr[i]) {
                count ++;
                per ++;;
            }

            if(per == 3) {
                per = 0;
            }
        }

        System.out.println(count);
    }
}
