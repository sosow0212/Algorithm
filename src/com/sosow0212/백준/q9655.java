package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1001];

        dp[1] = true;
        dp[2] = false;

        for(int i=3; i<=n; i++)
            dp[i] = dp[i-2];

        System.out.print(dp[n]? "SK" : "CY");
    }
}
