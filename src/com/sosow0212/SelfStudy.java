package com.sosow0212;

import java.util.*;

public class SelfStudy {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int count = 0;
    static List<Integer> ans = new ArrayList<>();
    static int[][] pos = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        boolean zero = true;

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    zero = false;
                }

            }
        }

        if (zero == true) {
            System.out.println("0");
            System.out.println("0");
            return;
        }


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                count = 0;
                if(arr[i][j] == 1 && !visited[i][j]) {
                    count ++;
                    bfs(i, j);
                    ans.add(count);
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        System.out.println(ans.get(ans.size()-1));

    }

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while(!queue.isEmpty()) {
            int[] nowArr = queue.poll();
            int nowx = nowArr[0];
            int nowy = nowArr[1];

            for(int i=0; i<pos.length; i++) {
                int nx = nowx + pos[i][0];
                int ny = nowy + pos[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    count ++;
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
