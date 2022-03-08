package com.sosow0212.백준;

import java.util.Scanner;

public class q11034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i=0; i<3; i++) {
            arr[i] = sc.nextInt();
        }

        int A = arr[1] - arr[0];
        int B = arr[2] - arr[1];

        System.out.println(Math.max(A,B) - 1);

    }
}
