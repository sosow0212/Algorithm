package com.sosow0212.test;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test {
    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[][] pos = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<pos.length; i++) {
                int nX = nowX + pos[i][0];
                int nY = nowY + pos[i][1];

                if(nX < 0 || nX >= n || nY < 0 || nY >= m || visited[nX][nY] || graph[nX][nY] == 0) {
                    continue;
                }

                visited[nX][nY] = true;
                graph[nX][nY] = graph[nowX][nowY] + 1;
                queue.add(new int[] {nX, nY});
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String str = sc.next();
            for(int j=0; j<m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        bfs(0,0);
        System.out.println(graph[n-1][m-1]);
    }
}