package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리2 {
    static int[][] map;
    static int[][] visited;
    static int answer;
    static boolean canNotDone = true;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int solution(int[][] maps) {
        answer = 0;

        map = maps;
        visited = new int[map.length][map[0].length];

        bfs();
        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        return answer;
    }

    public static void bfs() {
        visited[0][0] = 1;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            answer++;
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == map.length - 1 && nowY == map[0].length - 1) {
                canNotDone = false;
            }

            for (int i = 0; i < pos.length; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[nowX][nowY] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] map = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(map)); // 11
    }
}
