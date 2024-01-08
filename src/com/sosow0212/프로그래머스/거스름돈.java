package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class 거스름돈 {

    // dfs 풀이 -> 시간초과

    private static final int MOD = 1000000007;

    static int answer;
    static Set<List<Integer>> combinations;

    public static int solution(int n, int[] money) {
        answer = 0;
        combinations = new LinkedHashSet<>();
        permutation(0, new ArrayList<>(), n, money);
//        System.out.println(combinations);

        return combinations.size() % MOD;
    }

    static void permutation(int sum, List<Integer> arr, int n, int[] money) {
        if (sum == n) {
            Collections.sort(arr);
            combinations.add(arr);
            return;
        }

        if (sum > n) {
            return;
        }

        for (int i = 0; i < money.length; i++) {
            if (sum > n) {
                break;
            }

            sum += money[i];
            arr.add(Integer.valueOf(money[i]));

            permutation(sum, new ArrayList<>(arr), n, money);

            arr.remove(Integer.valueOf(money[i]));
            sum -= money[i];
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] money = {1, 2, 5};

        // 4
        System.out.println(solution(n, money));
    }
}
