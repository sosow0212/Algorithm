package com.sosow0212.백준;

import java.util.Scanner;

public class q5565 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] arr = new int[9];

        for(int i=0; i<9; i++) {
            arr[i] = sc.nextInt();
            sum -= arr[i];
        }

        System.out.println(sum);
    }
}
