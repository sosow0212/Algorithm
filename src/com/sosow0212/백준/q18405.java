package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class q18405 {

    static int n;
    static int k;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int s;
    static int r;
    static int c;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Map<Integer, List<int[]>> virusPosition;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        answer = 0;
        virusPosition = new HashMap<>();

        for (int i = 1; i <= k; i++) {
            virusPosition.put(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] != 0) {
                    visited[i][j] = true;
                    List<int[]> positionOfVirus = virusPosition.get(map[i][j]);
                    positionOfVirus.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        s = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            List<int[]> positions = virusPosition.get(i);

            for (int[] position : positions) {
                q.add(position);
            }
        }

        int time = 0;

        while (!q.isEmpty()) {
            time++;

            // 모두 spread
            for (int i = 1; i <= k; i++) {
                List<int[]> positions = virusPosition.get(i);
                virusPosition.put(i, new ArrayList<>());

                if (positions.isEmpty()) {
                    continue;
                }

                for (int[] now : positions) {
                    for (int j = 0; j < pos.length; j++) {
                        int nr = now[0] + pos[j][0];
                        int nc = now[1] + pos[j][1];

                        if (!(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc])) {
                            continue;
                        }

                        visited[nr][nc] = true;
                        map[nr][nc] = now[2];
                        List<int[]> newPositions = virusPosition.get(i);
                        newPositions.add(new int[]{nr, nc, now[2]});
                    }
                }
            }

            if (time == s) {
                break;
            }
        }

        answer = map[r - 1][c - 1];
    }
}
