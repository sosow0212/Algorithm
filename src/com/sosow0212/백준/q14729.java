package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q14729 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == 7) {
                break;
            }

            sb.append(String.format("%.3f\n", arr[i]));
        }

        System.out.println(sb.toString());

    }
}
