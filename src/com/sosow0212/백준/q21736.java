package com.sosow0212.백준;

import java.util.Scanner;

public class q21736 {

    private static int n, m;
    private static boolean[][] visited;
    private static char[][] map;
    private static int answer = 0;
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int lr, lc;

    public static void main(String[] args) {
        initData();
        getAnswer();
        if(answer == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(answer);
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                if (c == 'I') {
                    lr = i;
                    lc = j;
                }
            }
        }
    }

    private static void getAnswer() {
        dfs(lr, lc);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        if (map[row][col] == 'P') {
            answer++;
        }

        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && (map[nr][nc] == 'O'
                    || map[nr][nc] == 'P')) {
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }
    }
}
