package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q16947 {

    static List<Integer>[] list = new ArrayList[3001];
    static int[] visit = new int[3001], dist = new int[3001];

    static int DFS(int x, int before){

        if(visit[x] == 1)
            return x;

        visit[x] = 1;

        for(int next:list[x]){

            if(next == before) continue;

            int result = DFS(next, x);

            if(result == -2) return -2;
            if(result > 0){
                visit[x] = 2;
                if(x == result) return -2;
                else return result;
            }
        }
        return -1;
    }

    static boolean[] check = new boolean[3001];
    static void BFS(int x){

        Queue<Integer> Q = new LinkedList<>();

        check[x] = true;
        Q.add(x);

        while(!Q.isEmpty()){
            int cur = Q.poll();

            for(int next:list[cur])
                if(visit[next] != 2 && !check[next]){

                    check[next] = true;
                    dist[next] = dist[cur] + 1;
                    Q.add(next);
                }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int home = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            list[home].add(target);
            list[target].add(home);
        }

        DFS(1, 0);

        for(int i=1; i<=n; i++)
            if(visit[i] == 2)
                BFS(i);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++)
            sb.append(dist[i]).append(' ');

        System.out.println(sb);
    }
}