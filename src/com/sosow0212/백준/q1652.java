package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = str[j].charAt(0);
            }
        }

        int hei = 0;
        int wid = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n) {
                    if (arr[i][j] == '.' && arr[i + 1][j] == '.' && (i + 2 >= n || arr[i + 2][j] == 'X')) {
                        wid += 1;
                    }
                }
                if (j + 1 < n) {
                    if (arr[i][j] == '.' && arr[i][j + 1] == '.' && (j + 2 >= n || arr[i][j + 2] == 'X')) {
                        hei += 1;
                    }
                }
            }
        }
        System.out.println(hei + " " + wid);
    }
}
