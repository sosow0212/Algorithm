package com.sosow0212.etc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs미로탈출 {

    static int n, m;
    static int graph[][] = new int[200][200];

    static int pos[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static class Node {
        final private int x;
        final private int y;
        private int value;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,1));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for(int i=0; i<4; i++) {
                int nx = x + pos[i][0];
                int ny = y + pos[i][1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    // 미로 범위 벗어난 경우
                    continue;
                }

                if(graph[nx][ny] == 1) {
                    // 이미 왔거나, 괴물의 위치면 무시
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
