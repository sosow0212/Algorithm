package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q5014 {

    static int f, s, g, u, d;
    static boolean[] visited;
    static int[] move;
    static int[] pos = new int[2]; // u, d를 담아놓은 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        f = sc.nextInt(); // 총 f층
        s = sc.nextInt(); // 현재 있는 층 s
        g = sc.nextInt(); // 스타트 링크가 있는 층 g
        u = sc.nextInt(); // 위로 가능 버튼 u // 몇 번 위로 가는지?
        d = sc.nextInt(); // 아래로 가는 버튼 d // 몇 번 아래로 가는지?

        pos = new int[]{u, -d}; // -d 임을 유의
        move = new int[f + 1];
        visited = new boolean[f + 1];
        bfs(s);

    }

    static void bfs(int s) {
        Queue<Integer> q = new LinkedList<>();

        q.add(s);
        visited[s] = true;
        move[s] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == g) {
                System.out.println(move[now]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = now + pos[i];

                if (next <= f && next >= 1 && !visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    move[next] = move[now] + 1;
                }

            }
        }

        System.out.println("use the stairs");
    }
}
