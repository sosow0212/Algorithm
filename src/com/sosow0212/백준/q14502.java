package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q14502 {

    public static int map[][] = new int[8][8];
    public static int X;
    public static int Y;
    public static int max = 0;
    public static int dx[] = new int[]{0, 0, 1, -1};
    public static int dy[] = new int[]{1, -1, 0, 0};


    public static void main(String[] args) {
        // 벽을 3개 세운다
        // 바이러스를 퍼뜨린다.
        // 0의 개수를 구한다
        // 이 값을 max값과 계속 비교하면서 최댓값을 구한다.

        Scanner sc = new Scanner(System.in);
        Y = sc.nextInt();
        X = sc.nextInt();

        // 그래프 모양을 보면 y는 위에서부터 시작해서
        /**
         * ex
         * 2 0 0 1 1 0
         * 0 0 1 0 1 2
         * 0 0 1 1 1 1
         * 이런식으로 그래프는 위에서 그려지므로 아래처럼 for문을 돌림.
         */
        for (int y = Y-1; y >= 0; y--) {
            for(int x=0; x<X; x++) {
                map[x][y] = sc.nextInt();
            }
        }
        recursive(0);
        System.out.println(max);
    }


    // 벽세우기는 최대 3개까지 가능
    public static void recursive(int index) {

        if (index == 3) {
            // 바이러스를 퍼트려본다.
            // 남아있는 0의 갯수를 센다.

            int countOf0 = bfs();
            max = Math.max(max, countOf0);
            return;
        }

        // 모든 경우의 수로 벽을 세워본다.
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    recursive(index + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    // 바이러스를 퍼트리고 안전지대의 수를 반환함
    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[X][Y];
        // 2인 위치를 bfs의 시작위치로 하자
        // ==> q에 넣고 시작하자는 말

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int list[] = q.poll();
            int curx = list[0];
            int cury = list[1];

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if (nx >= 0 && nx < X && ny >= 0 && ny < Y && check[nx][ny] == false && map[nx][ny] == 0) {
                    check[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // 안전영역의 갯수 구하기
        // 0이면서 && 바이러스가 퍼지지 않는 곳 => 안전영역
        int count = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 0 && check[i][j] == false) {
                    count++;
                }
            }
        }
        return count;
    }
}
