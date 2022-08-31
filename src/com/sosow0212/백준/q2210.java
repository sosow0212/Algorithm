package com.sosow0212.백준;

import java.util.*;

public class q2210 {
    static HashSet<String> ans = new HashSet<>();
    static int arr[][] = new int[5][5];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j);
            }
        }

        System.out.println(ans.size());

    }

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, ""));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.str.length() >= 6) {
                ans.add(cur.str);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

                q.add(new Node(nx, ny, cur.str + String.valueOf(arr[nx][ny])));
            }
        }
    }

    public static class Node {
        int x;    // x좌표
        int y;    // y좌표
        String str;    // 선택한 숫자

        Node(int x, int y, String str) {
            this.x = x;
            this.y = y;
            this.str = str;
        }
    }

}