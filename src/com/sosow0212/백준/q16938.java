package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class q16938 {

    static int n;
    static int l;
    static int r;
    static int x;
    static int answer;
    static int[] arr;
    static boolean[] visited;
    static Set<List<Integer>> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        x = sc.nextInt();
        answer = 0;
        arr = new int[n];
        visited = new boolean[n];
        set = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        permutation(0, new ArrayList<>());
        System.out.println(set.size());
    }

    static void permutation(int index, List<Integer> solve) {
        if (index >= 2 && index <= n) {
            Collections.sort(solve);

            int sum = solve.stream()
                    .mapToInt(Integer::intValue)
                    .sum();

            if (sum >= l && sum <= r && solve.get(solve.size() - 1) - solve.get(0) >= x) {
                set.add(solve);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solve.add(arr[i]);
                permutation(index + 1, solve);
                solve.remove(Integer.valueOf(arr[i]));
                visited[i] = false;
            }
        }
    }
}
