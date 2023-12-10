package com.sosow0212.exam.kin;

import java.util.ArrayList;
import java.util.Arrays;

public class q2 {

    // [정점, 도넛, 막대, 8자]
    static int n;
    static ArrayList<Integer>[] list;
    static int[] middleArr;
    static int middle;
    static boolean[] visited;
    static boolean[] visited2;
    static boolean[] allVisited;
    static boolean isLoop;
    static int count;
    static boolean isCircle;

    public static int[] solution(int[][] edges) {
        int[] answer = new int[4];

        n = edges.length;
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        visited2 = new boolean[n + 1];
        allVisited = new boolean[n + 1];
        middleArr = new int[n + 1];
        isLoop = false;
        middle = 0;

        count = 0;
        initGraph(edges);

        answer[0] = middle;
        visited = new boolean[n + 1];

        // [정점, 도넛, 막대, 8자]
        for (Integer node : list[middle]) {
            isCircle = false;
            visited2 = new boolean[n + 1];
            count = 0;
            dfs(node);

            if (isLoop) {
                if (isCircle) {
                    answer[1]++;
                } else {
                    answer[3]++;
                }
            } else {
                answer[2]++;
            }
        }

        return answer;
    }

    static void dfs(int now) {
        visited[now] = true;

        for (Integer next : list[now]) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                dfs(next);
                continue;
            }

            if (visited[next] && !visited2[next]) {
                isLoop = true;
                visited2[next] = true;
                dfs(next);
                continue;
            }

            if (visited[next] && visited2[next]) {
                if (count <= 2 && list[now].contains(next) && list[next].contains(now)) {
                    isCircle = true;
                    return;
                }

                if (count >= 3) {
                    isCircle = false;
                    return;
                }
            }
        }
    }

    private static void initGraph(final int[][] edges) {
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList();
        }

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            list[node1].add(node2);
            middleArr[node1]++;
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (middleArr[i] > max) {
                max = middleArr[i];
                middle = i;
            }
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{2, 3}, {4, 3}, {1, 1}, {2, 1}};

        // 2,1,1,0
        System.out.println(Arrays.toString(solution(edges)));


        int[][] e2 = {
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        };
        // 4,0,1,2
        System.out.println(Arrays.toString(solution(e2)));
    }
}
