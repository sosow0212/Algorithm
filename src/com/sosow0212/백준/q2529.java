package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class q2529 {

    static int n;
    static String[] arr;
    static List<String> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");
        list = new ArrayList<>();

        visited = new boolean[10];

        dfs("", 0);

        System.out.print(list.get(list.size() - 1) + "\n");
        System.out.print(list.get(0));
    }

    static void dfs(String num, int idx) {
        if (idx == n + 1) {
            list.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                continue;
            }

            if (idx == 0 || isFit(num.charAt(idx - 1) - '0', i, arr[idx - 1])) {
                visited[i] = true;
                dfs(num + i, idx + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isFit(int a, int b, String c) {
        if (c.equals(">")) {
            return a > b;
        } else if (c.equals("<")) {
            return a < b;
        }
        return true;
    }
}
