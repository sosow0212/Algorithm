package com.sosow0212.백준;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class q2331 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        int[] dp = new int[100000];
        Map<Integer, Integer> map = new HashMap<>();
        dp[n] = n;
        map.put(n, 1);

        for (int i = n + 1; i < dp.length; i++) {
            String[] split = String.valueOf(dp[i - 1]).split("");

            int sum = 0;
            for (String s : split) {
                int num = Integer.parseInt(s);
                sum += Math.pow(num, p);
            }

            dp[i] = sum;
            map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
        }

        List<Integer> keySet = map.keySet().stream()
                .filter(it -> map.get(it) == 1)
                .collect(Collectors.toList());

        System.out.println(keySet.size());
    }
}
