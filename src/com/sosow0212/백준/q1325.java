package com.sosow0212.백준;

import java.io.*;
import java.util.*;

public class q1325 {
    static int nV; //정점의 개수
    static int nE; //간선의 개수
    static boolean[] visit; //방문 배열
    static ArrayList<Integer>[] fc;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());

        cnt = new int[nV + 1];
        fc = new ArrayList[nV + 1];

        for (int i = 1; i <= nV; i++) {
            fc[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int t1 = Integer.parseInt(st.nextToken());
            int t2 = Integer.parseInt(st.nextToken());

            fc[t1].add(t2);
        }

        for (int i = 1; i <= nV; i++) {
            visit = new boolean[nV + 1];
            dfs(i);
        }


        StringBuilder sb = new StringBuilder();

        int max = 0;

        for (int i = 1; i <= nV; i++) {
            if (cnt[i] > max)
                max = cnt[i];
        }

        for (int i = 1; i <= nV; i++) {
            if (max == cnt[i])
                sb.append(i + " ");
        }

        System.out.println(sb.toString());
    }


    static void dfs(int n) {
        visit[n] = true;
        for (int index : fc[n]) {
            if (!visit[index]) {
                cnt[index]++;
                dfs(index);
            }
        }
    }
}
