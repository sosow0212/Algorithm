package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q2178 {

    static int n, m;
    static int Graph[][];
    static boolean Visited[][];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nX = nowX + dx[i];
                int nY = nowY + dy[i];

                if(nX < 0 || nY < 0 || nX >= n || nY >= m)
                    continue;

                if(Visited[nX][nY] || Graph[nX][nY] == 0)
                    continue;

                q.add(new int[] {nX, nY});
                Graph[nX][nY] = Graph[nowX][nowY] + 1;
                Visited[nX][nY] = true;

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        Graph = new int[n][m];
        Visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                Graph[i][j] = str.charAt(j) - '0';
            }
        }

        Visited[0][0] = true;
        bfs(0,0);
        System.out.println(Graph[n-1][m-1]);


    }
}
