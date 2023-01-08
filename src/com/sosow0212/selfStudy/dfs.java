package com.sosow0212.selfStudy;

import java.util.Scanner;

public class dfs {
    static int[][] graph = {{0, 0, 1, 1, 0}, {0, 0, 0, 1, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}};
    static boolean[][] visited = new boolean[4][5];
    static int[][] pos = {{0, -1}, {0, 1}, {-1, 0}, {0, 1}};

    static boolean dfs(int r, int c) {
        if(r <= -1 || r >= 4 || c <= -1 || c >= 5) {
            return false;
        }


        if(visited[r][c] == false) {
            visited[r][c] = true;
            for(int i=0; i<4; i++) {
                int nr = r + pos[i][0];
                int nc = c = pos[i][1];
                dfs(nr,nc);
            }
        }
        return false; // false로 해줘야 처리
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;

        for(int i=0; i<4; i++) {
            for(int j=0; j<5; j++) {
                if(dfs(i,j)) {
                    count ++;
                }
            }
        }

        System.out.println(count);
    }
}
