package com.sosow0212.프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    private static int[] startPos, endPos, leverPos;
    private static int n, m;
    private static int answer;
    private static char[][] map;
    private static int[][] time;
    private static boolean[][] visited;
    private static int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int solution(String[] maps) {
        initData(maps);
        getAnswer(startPos[0], startPos[1]);
        return answer;
    }

    private void getAnswer(int startRow, int startCol) {
        int leverTime = findLever(startRow, startCol);
        if (leverTime == -1) {
            answer = -1;
            return;
        }

        findExit(leverPos[0], leverPos[1], leverTime);

        if (time[endPos[0]][endPos[1]] == 0) {
            answer = -1;
            return;
        }

        answer = time[endPos[0]][endPos[1]];
    }

    private void findExit(int startRow, int startCol, int leverTime) {
        visited = new boolean[n][m];
        visited[startRow][startCol] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startRow, startCol});
        time[startRow][startCol] = leverTime;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != 'X') {
                    time[nr][nc] = time[now[0]][now[1]] + 1;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    private int findLever(int startRow, int startCol) {
        Queue<int[]> q = new LinkedList<>();
        visited[startRow][startCol] = true;
        q.add(new int[]{startRow, startCol});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < pos.length; i++) {
                int nr = now[0] + pos[i][0];
                int nc = now[1] + pos[i][1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && map[nr][nc] != 'X') {
                    time[nr][nc] = time[now[0]][now[1]] + 1;
                    visited[nr][nc] = true;

                    if (map[nr][nc] == 'L') {
                        return time[nr][nc];
                    }

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return -1;
    }

    private void initData(String[] maps) {
        n = maps.length;
        m = maps[0].length();

        startPos = new int[2];
        endPos = new int[2];
        leverPos = new int[2];
        time = new int[n][m];
        map = new char[n][m];
        visited = new boolean[n][m];
        answer = 0;

        for (int i = 0; i < n; i++) {
            String line = maps[i];
            for (int j = 0; j < m; j++) {
                char piece = line.charAt(j);
                if (piece == 'S') {
                    startPos[0] = i;
                    startPos[1] = j;
                }

                if (piece == 'E') {
                    endPos[0] = i;
                    endPos[1] = j;
                }

                if (piece == 'L') {
                    leverPos[0] = i;
                    leverPos[1] = j;
                }

                map[i][j] = piece;
            }
        }
    }

    public static void main(String[] args) {
        미로탈출 sol = new 미로탈출();
        String[] map = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        System.out.println(sol.solution(map));// 16

        String[] map2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};
        System.out.println(sol.solution(map2)); // -1

        String[] map3 = {"SOEOL", "XXXXO", "OOOOO", "OXXXX", "OOOOO"};
        System.out.println(sol.solution(map3)); // 6
    }
}
