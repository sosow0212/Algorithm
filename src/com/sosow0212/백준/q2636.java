package com.sosow0212.백준;

import java.util.Scanner;

public class q2636 {
    private static int row, col;
    private static int[][] map;
    private static boolean[][] visited;
    private static int countOfCheese;
    private static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int timeOfMeltingAll = 0;

    public static void main(String[] args) {
        initData();
        getAnswer();
        printAnswer();
    }

    private static void getAnswer() {
        for (timeOfMeltingAll = 0; isCheeseBeen(); timeOfMeltingAll++) {
            visited = new boolean[row][col];
            countOfCheese = 0;
            visited[0][0] = true;
            dfs(0, 0);
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        map = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[row][col];
    }

    private static void printAnswer() {
        System.out.println(timeOfMeltingAll);
        System.out.println(countOfCheese);
    }

    private static boolean isCheeseBeen() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < pos.length; i++) {
            int dx = x + pos[i][0];
            int dy = y + pos[i][1];

            if (dx < 0 || dy < 0 || dx >= row || dy >= col) {
                continue;
            }

            if (!visited[dx][dy]) {
                visited[dx][dy] = true;
                if (map[dx][dy] == 1) {
                    map[dx][dy] = 2;
                    countOfCheese++;
                } else {
                    dfs(dx, dy);
                }
            }
        }
    }
}
