package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3184 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static List<int[]> sheep, inSheep;
    static List<int[]> wolf, inWolf;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        sheep = new ArrayList<>();  // 영역 내 양의 위치 저장
        wolf = new ArrayList<>(); // 영역 내 늑대 위치 저장

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'v' || map[i][j] == 'o') { // 늑대와 양을 만난다면
                    wolf = new ArrayList<>();
                    sheep = new ArrayList<>();
                    attack(i, j);    // 영역 검사
                    if (wolf.size() < sheep.size()) {    // 양의 수가 더 많을 때
                        for (int[] w : wolf) {
                            map[w[0]][w[1]] = '.';    // 늑대 위치 값 변경
                        }
                    } else {
                        for (int[] s : sheep) {    // 늑대 수가 더 많을 때
                            map[s[0]][s[1]] = '.';    // 양의 위치 값 변경
                        }
                    }
                }
            }
        }

        int wolfCnt = 0;
        int sheepCnt = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'v') {
                    wolfCnt++;
                } else if (map[i][j] == 'o') {
                    sheepCnt++;
                }
            }
        }

        System.out.println(sheepCnt + " " + wolfCnt);
    }

    /* 영역 검사를 위한 BFS */
    private static void attack(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] == 'v') {
                wolf.add(new int[]{cur[0], cur[1]});
            } else if (map[cur[0]][cur[1]] == 'o') {
                sheep.add(new int[]{cur[0], cur[1]});
            }

            for (int d = 0; d < 4; d++) {
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if (0 <= ni && ni < R && 0 <= nj && nj < C) {
                    if (!visited[ni][nj] && map[ni][nj] != '#') {
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
    }
}
