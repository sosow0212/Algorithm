package com.sosow0212.woowa_study.set7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q17127 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] arrStr = reader.readLine().split(" ");
        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        for (int i = 0; i < 4; i++) {
            int data = 1;
            for (int j = i; j < n - 3 + i; j++) {
                data *= arr[j];
                check[j] = true;
            }

            for (int k = 0; k < n; k++) {
                if (!check[k]) {
                    data += arr[k];
                }
            }

            if (data > max) {
                max = data;
            }

            for (int it = 0; it < n; it++) {
                if (check[it]) {
                    check[it] = false;
                }
            }
        }

        System.out.println(max);
    }
}
