package com.sosow0212.백준;

import java.util.Scanner;

public class q16234 {

    private static int n;
    private static int l, r;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int answer;
    private static boolean checkOfVisited;
    private static int sum, total;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][n];
        visited = new boolean[n][n];
        checkOfVisited = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        answer = 0;
    }

    private static void getAnswer() {

        while (true) {
            checkOfVisited = false;
            visited = new boolean[n][n];
            sum = 0;
            total = 0;

            // 1. 탐색해서 맵에 true ,false 체크해주기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(i, j);
                }
            }

            // 2. 평균 내서 값 바꾸기
            boolean[][] union = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        checkOfVisited = true;

                        total++;
                        dfsForCalculation(i, j);

                    }
                }
            }

            // 2-1. 바뀐게 없다면 중지
            if (!checkOfVisited) {
                System.out.println(answer);
                return;
            }

            // 2-2. 바뀐게 있다면 정답 +1 해주고, 계산
            answer++;


            // test
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void dfsForCalculation(int row, int col) {
        visited[row][col] = false;
        sum += map[row][col];

        for(int i=0; i<pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if(!isPermitRange(nr, nc) && visited[nr][nc]) {
                dfsForCalculation(nr, nc);
            }
        }

    }

    private static void dfs(int row, int col) {
        for (int i = 0; i < pos.length; i++) {
            int nr = row + pos[i][0];
            int nc = col + pos[i][1];

            if (!isPermitRange(nr, nc)) {
                continue;
            }

            int abs = Math.abs(map[row][col] - map[nr][nc]);
            if (!isPermitAbs(abs)) {
                continue;
            }

            visited[row][col] = true;
            visited[nr][nc] = true;
        }
    }

    private static boolean isPermitAbs(int abs) {
        return abs >= l && abs <= r;
    }

    private static boolean isPermitRange(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }
}
