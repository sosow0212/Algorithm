package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q1058 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] map = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (map[j] == 'Y')
                    matrix[i][j] = 1;
                else
                    matrix[i][j] = 1000000;
            }
        }
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k) continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 || matrix[i][j] == 2)
                    cnt++; //
            }
            ans = Math.max(ans, cnt);
        }
        System.out.println(ans);
    }
}