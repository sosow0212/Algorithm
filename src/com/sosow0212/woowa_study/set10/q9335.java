package com.sosow0212.woowa_study.set10;

import java.util.ArrayList;
import java.util.Scanner;

public class q9335 {

    static int n;
    static int answer;
    static ArrayList<Integer>[] list;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {
            answer = Integer.MAX_VALUE;
            n = sc.nextInt();
            list = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 1; j <= n; j++) {
                int friendCount = sc.nextInt();

                for (int k = 0; k < friendCount; k++) {
                    int friend = sc.nextInt();
                    list[j].add(friend);
                }
            }

            visited = new int[n + 1];
            dfs(0, 0);
            System.out.println(answer);
        }
    }

    private static void dfs(int index, int count) {
        if (count >= answer) {
            return;
        }

        if (index == n) {
            for (int i = 1; i <= n; i++) {
                if (visited[i] == 0) {
                    return;
                }
            }
            answer = count;
            return;
        }

        visited[index + 1]++;
        for (int friend : list[index + 1]) {
            visited[friend]++;
        }

        dfs(index + 1, count + 1);
        visited[index + 1]--;

        for (int friend : list[index + 1]) {
            visited[friend]--;
        }

        dfs(index + 1, count);
    }
}

// 1 2 3
// 1
// 2
// 3
// 1 2
// 1 3
// 2 3
// 1 2 3

//1
//8
//4 2 3 4 5
//3 1 6 7
//3 1 5 8
//1 1
//2 1 2
//1 2
//1 2
//1 3

//3
