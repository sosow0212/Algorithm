package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int round = (int) Math.round(n * 0.15);

        int sum = 0;
        int count = 0;

        for (int i = round; i < n - round; i++) {
            sum += arr[i];
            count++;
        }

        System.out.println(Math.round((double) sum / (double) count));
    }
}
