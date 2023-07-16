package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.List;

public class 배달 {

    static List<List<Node>> map;
    static boolean[] visit;
    static int k;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        boolean[] visited = new boolean[N + 1];
        visit = new boolean[N + 1];
        k = K;

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }

        for (int[] info : road) {
            map.get(info[0]).add(new Node(info[1], info[2]));
            map.get(info[1]).add(new Node(info[0], info[2]));
        }

        visited[1] = true;
        visit[1] = true;
        dfs(1, 0, visited);

        for (boolean b : visit) {
            System.out.println(b);

            if (b) {
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int city, int dist, boolean[] visited) {
        // 2 1
        List<Node> nodes = map.get(city);
        for (Node node : nodes) {
            int end = node.getEnd();
            int value = node.getValue();

            if (!visited[end] && dist + value <= k) {
                visited[end] = true;
                visit[end] = true;
                dfs(end, dist + value, visited);
                visited[end] = false;
            }
        }
    }

    class Node {
        private int end;
        private int value;

        public Node(final int end, final int value) {
            this.end = end;
            this.value = value;
        }

        public int getEnd() {
            return end;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return this.end + " " + this.value;
        }
    }

    public static void main(String[] args) {
        배달 sol = new 배달();

        int n1 = 5;
        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int k1 = 3;

        // 4
//        System.out.println(sol.solution(n1, road1, k1));

        int n = 6;
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int k = 4;

//         4
        System.out.println(sol.solution(n, road, k));
    }
}
