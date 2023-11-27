package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q16174 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        bfs(0, 0);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int moveCount = map[now[0]][now[1]];

            if (moveCount == -1) {
                System.out.println("HaruHaru");
                return;
            }

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + (pos[i][0] * moveCount);
                int nc = now[1] + (pos[i][1] * moveCount);

                if (!(nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc])) {
                    continue;
                }

                q.add(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }

        System.out.println("Hing");
    }
}
