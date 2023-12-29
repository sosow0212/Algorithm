package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q3980 {

    static final int N = 11;
    static final Scanner sc = new Scanner(System.in);

    static int[][] value;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) {
        int test = sc.nextInt();

        for (int i = 0; i < test; i++) {
            solve();
        }
    }

    static void solve() {
        value = new int[N][N];
        answer = 0;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                value[i][j] = sc.nextInt();
            }
        }

        permutation(0, 0, new ArrayList<>());

        System.out.println(answer);
    }

    static void permutation(int index, int sum, List<Integer> list) {
        if (index == N) {
            int temp = 0;

            for (Integer i : list) {
                temp += i;
            }

            answer = Math.max(answer, temp);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (value[index][i] != 0 && !visited[i]) {
                sum += value[index][i];
                visited[i] = true;
                list.add(value[index][i]);

                permutation(index + 1, sum + value[index][i], list);

                list.remove(Integer.valueOf(value[index][i]));
                sum -= value[index][i];
                visited[i] = false;
            }
        }
    }
}
