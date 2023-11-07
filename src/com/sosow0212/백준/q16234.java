package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class q16234 {

    static int n;
    static int l;
    static int r;
    static int[][] map;
    static boolean[][] visited;
    static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int answer;
    static Set<int[]> set;
    static int mod;
    static boolean[][] visitedNext;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        answer = 0;
        set = new LinkedHashSet<>();
        mod = 0;

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            // 1. 국경 열기
            if (!isOpen()) {
                break;
            }

            List<int[]> list = new ArrayList<>(set);
            visitedNext = new boolean[n][n];

            for (int i = 0; i < list.size(); i++) {
                int[] position = list.get(i);

                if (visited[position[0]][position[1]] && !visitedNext[position[0]][position[1]]) {
                    visitedNext[position[0]][position[1]] = true;
                    bfs(position[0], position[1]);
                    answer++;
                }
            }

            for (int[] ints : map) {
                System.out.println(Arrays.toString(ints));
            }
            for (boolean[] ints : visited) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
            System.out.println();
        }

        System.out.println(answer);
    }

    static boolean isOpen() {
        visited = new boolean[n][n];
        mod = 0;

        boolean isOpen = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < pos.length; k++) {
                    int nr = i + pos[k][0];
                    int nc = j + pos[k][1];

                    if (!(nr >= 0 && nr < n && nc >= 0 && nc < n)) {
                        continue;
                    }

                    int abs = Math.abs(map[nr][nc] - map[i][j]);

                    if (abs >= l && abs <= r) {
                        visited[i][j] = true;
                        visited[nr][nc] = true;
                        set.add(new int[]{nr, nc});
                        mod += map[i][j];
                        isOpen = true;
                    }
                }
            }
        }

        return isOpen;
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> set = new LinkedHashSet<>();

        q.add(new int[]{row, col});
        set.add(new int[]{row, col});

        int sum = map[row][col];

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && visited[nr][nc] && !visitedNext[nr][nc]) {
                    sum += map[nr][nc];
                    q.add(new int[]{nr, nc});
                    set.add(new int[]{nr, nc});
                    visitedNext[nr][nc] = true;
                }
            }
        }

        System.out.println(sum + " " + set.size());
        int mod = (int) Math.floor(sum / set.size());
        System.out.println("mod = " + mod);

        for (int[] pos : set) {
            map[pos[0]][pos[1]] = mod;
        }
    }
}
