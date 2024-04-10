package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1941_2 {

    static final int n = 5;

    static char[][] map;
    static boolean[][] visited;
    static int answer;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        permutation(0, 0);

        System.out.println(answer);
    }

    static void permutation(int index, int start) {
        if (index == 7) {
            if (isSom()) {
                answer++;
            }

            return;
        }

        for (int i = start; i < 25; i++) {
            int row = i / 5;
            int col = i % 5;

            visited[row][col] = true;
            permutation(index + 1, i + 1);
            visited[row][col] = false;
        }
    }

    static boolean isSom() {
        int som = 0;
        int linked = 0;

        boolean[][] copyVisited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            copyVisited[i] = visited[i].clone();
        }

        int r = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copyVisited[i][j]) {
                    r = i;
                    c = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                    continue;
                }

                if (!copyVisited[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] == 'S') {
                    som++;
                }

                copyVisited[nr][nc] = false;
                linked++;
                q.add(new int[]{nr, nc});
            }
        }

        return som >= 4 && linked == 7;
    }
}
