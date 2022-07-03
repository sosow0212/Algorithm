package com.sosow0212.백준;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class q1261 {

    static int n, m;
    static int[][] graph;
    static int[][] dist;
    static boolean[][] visited;
    static int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {1, -1}};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];
        dist = new int[n][m];

        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(dist[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[] {x,y});
        visited[0][0] = true;

        while (!deque.isEmpty()) {
            int[] arr = deque.pollLast();
            int nowX = arr[0];
            int nowY = arr[1];

            for(int i=0; i<pos.length; i++) {
                int nx = nowX + pos[i][0];
                int ny = nowY + pos[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if(graph[nx][ny] == 0) {
                        dist[nx][ny] = dist[x][y];
                        deque.addLast(new int[] {nx,ny});
                    } else {
                        dist[nx][ny] = dist[x][y] + 1;
                        deque.addFirst(new int[] {nx, ny});
                    }
                    visited[nx][ny] = true;
                } else {
                    continue;
                }
            }
        }
    }
}
