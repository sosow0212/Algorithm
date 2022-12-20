package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> answer = new ArrayList<>();
        Stack<int[]> top = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int sizeOfTop = Integer.parseInt(st.nextToken());

            while (!top.isEmpty()) {
                if (top.peek()[1] >= sizeOfTop) {
                    answer.add(top.peek()[0]);
                    break;
                }
                top.pop();
            }

            if (top.isEmpty()) {
                answer.add(0);
            }
            top.push(new int[]{i, sizeOfTop});
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
