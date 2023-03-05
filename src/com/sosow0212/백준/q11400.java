package com.sosow0212.백준;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class q11400 {

    private static int v, e;
    private static ArrayList<ArrayList<Integer>> list;
    static int count = 1;
    static int[] orderTemp;
    static ArrayList<Node> answer;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        initData();
        findAnswer();
        printAnswer();
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        orderTemp = new int[v + 1];
        answer = new ArrayList<>();
        list = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }
    }

    private static void findAnswer() {
        for (int i = 1; i <= v; i++) {
            if (orderTemp[i] == 0) {
                dfs(i, 0, list);
            }
        }

        Collections.sort(answer, (a1, a2) -> (a1.x == a2.x) ? a1.y - a2.y : a1.x - a2.x);
    }

    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size())
                .append("\n");

        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i).x + " " + answer.get(i).y)
                    .append("\n");
        }
    }

    public static int dfs(int index, int parent, ArrayList<ArrayList<Integer>> list) {
        orderTemp[index] = count++;
        int in = orderTemp[index];

        for (int now : list.get(index)) {
            if (now == parent) {
                continue;
            }

            if (orderTemp[now] == 0) {
                int d = dfs(now, index, list);

                if (d > orderTemp[index]) {
                    if (now > index) {
                        answer.add(new Node(index, now));
                    } else {
                        answer.add(new Node(now, index));
                    }
                }
                in = Math.min(in, d);
            } else {
                in = Math.min(in, orderTemp[now]);
            }
        }

        return in;
    }
}
