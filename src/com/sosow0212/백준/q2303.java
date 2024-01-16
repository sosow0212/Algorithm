package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q2303 {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static Map<Integer, Integer> score;
    static int maxOfPlayer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][5];
        visited = new boolean[n][5];
        score = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            maxOfPlayer = 0;
            permutation(0, i - 1, new int[3]);
            score.put(i, maxOfPlayer);
        }

        int answer = -1;
        int maxValue = -1;
        for (Integer key : score.keySet()) {
            if (score.get(key) >= maxValue) {
                answer = key;
                maxValue = score.get(key);
            }
        }

        System.out.println(answer);
    }

    static void permutation(int index, int playerNumber, int[] pick) {
        if (index == 3) {
            int sum = 0;

            for (int i : pick) {
                sum += i;
            }

            String str = String.valueOf(sum);

            maxOfPlayer = Math.max(maxOfPlayer, str.charAt(str.length() - 1) - '0');
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (!visited[playerNumber][i]) {
                visited[playerNumber][i] = true;
                pick[index] = arr[playerNumber][i];
                permutation(index + 1, playerNumber, pick.clone());
                pick[index] = 0;
                visited[playerNumber][i] = false;
            }
        }
    }
}
