package com.sosow0212.exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Solution {

    private static final int IN = 10001;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t;
        t = sc.nextInt();
        int[][] arr = new int[IN][IN];

        int[][] pos = {{-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}};

        int num = 1;
        for (int i = 1; i < arr.length; i++) {

            for (int j = 1; j <= i; j++) {
                arr[i][j] = num;
                num++;
            }
        }

        /**
         * 1
         * 2 3
         * 4 5 6
         * 7 8 9 10
         * 1 2 3 4 5
         *
         */

        for (int test_case = 1; test_case <= t; test_case++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            if (s == e) {
                System.out.println("#" + test_case + " 0");
                continue;
            }

            int sRow = 0;
            int sCol = 0;
            int eRow = 0;
            int eCol = 0;
            boolean[][] visited = new boolean[IN][IN];
            int[][] dp = new int[IN][IN];

            // 출발점, 끝점 좌표
            for (int i = 0; i < IN; i++) {
                for (int j = 0; j < IN; j++) {
                    if (arr[i][j] == s) {
                        sRow = i;
                        sCol = j;
                    } else if (arr[i][j] == e) {
                        eRow = i;
                        eCol = j;
                    }
                }
            }

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sRow, sCol});
            dp[sRow][sCol] = 0;
            visited[sRow][sCol] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();

                if (now[0] == eRow && now[1] == eCol) {
                    break;
                }

                for (int i = 0; i < pos.length; i++) {
                    int nr = now[0] + pos[i][0];
                    int nc = now[1] + pos[i][1];

                    if (!(nr >= 0 && nr < IN && nc >= 0 && nc < IN && !visited[nr][nc])) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    dp[nr][nc] = dp[now[0]][now[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }

            System.out.println("#" + test_case + " " + dp[eRow][eCol]);
        }
    }
}
