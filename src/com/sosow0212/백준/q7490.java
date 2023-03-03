package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 다시 풀어야함
// 막힌 부분 : 숫자 사이의 공백 처리 부분
public class q7490 {

    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dfs(n, 0, "1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int index, int sum, String str) {
        if (index == n) {
            if (str.charAt(0) != '-') {
                System.out.println(str);
            }
        }

        dfs(index + 1, sum + 1, "");
        dfs(index - 1, sum - 1, "");
        if (index != 0) {
            dfs(index + 1, sum * 10 + 1, "");
            dfs(index - 1, sum * 10 - 1, "");
        }
    }
}
