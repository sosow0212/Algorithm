package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q18428 {
    private static int n;
    private static boolean answer = false;
    private static char[][] map;
    private static ArrayList<int[]> students = new ArrayList<>();

    private static int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        initData();
        getAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.next().charAt(0);
                if (map[i][j] == 'S') {
                    students.add(new int[]{i, j});
                }
            }
        }
    }

    private static void getAnswer() {
        dfs(0);
        System.out.println(answer ? "YES" : "NO");
    }

    private static void dfs(int countOfWalls) {
        if (countOfWalls == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(countOfWalls + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        char[][] mapForUsingBfs = new char[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mapForUsingBfs[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mapForUsingBfs[i][j] == 'T') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < pos.length; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];

                while (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (mapForUsingBfs[nx][ny] != 'O') {
                        visited[nx][ny] = true;
                        nx += pos[i][0];
                        ny += pos[i][1];
                    } else {
                        break;
                    }
                }
            }
        }
        if (areCatchStudents(visited)) {
//            System.out.println("YES");
            answer = true;
            return;
//            System.exit(0);
        }
    }

    private static boolean areCatchStudents(boolean[][] visited) {
        for (int[] student : students) {
            if (visited[student[0]][student[1]]) {
                return false;
            }
        }
        return true;
    }
}
