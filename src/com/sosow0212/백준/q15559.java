package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q15559 {

    private static int n, m;
    private static char[][] map;
    private static int[][] visited;
    private static HashMap<Character, int[]> posMap = new HashMap<>();
    private static int depth = 0;
    private static int answer = 0;

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new char[n][m];
        visited = new int[n][m];
        initPos();

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            map[i] = input.toCharArray();
        }
    }

    private static void initPos() {
        posMap.put('S', new int[]{1, 0});
        posMap.put('N', new int[]{-1, 0});
        posMap.put('E', new int[]{0, 1});
        posMap.put('W', new int[]{0, -1});
    }

    private static void getAnswer() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    depth++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int row, int col) {
        visited[row][col] = depth;

        int[] pos = posMap.get(map[row][col]);
        int nr = row + pos[0];
        int nc = col + pos[1];

        if (visited[nr][nc] == 0) {
            dfs(nr, nc);
        } else if (visited[nr][nc] == depth) {
            answer++;
        }
    }
}
