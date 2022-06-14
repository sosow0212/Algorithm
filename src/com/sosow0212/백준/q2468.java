package com.sosow0212.백준;

import java.util.Scanner;

public class q2468 {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int ans = 0;
    static int count = 0;

    static int dfs(int x, int y, int p) {
        visited[x][y] = true;

        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
            if (visited[nx][ny]) continue;
            if (arr[nx][ny] > p) {
                dfs(nx, ny, p);
            }
        }
        return 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int maxH = Integer.MIN_VALUE;

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                maxH = Math.max(maxH, arr[i][j]); // 1~max 까지 물에 잠기는 걸 고려
            }
        }

        // 물에 잠기게 하고 dfs() 돌리기
        for (int w = 0; w <= maxH; w++) {
            count = 0; // 안전지역
            visited = new boolean[n][n];

            // 안전지역이면 count 추가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && arr[i][j] > w)
                        count += dfs(i, j, w);
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);
    }
}
