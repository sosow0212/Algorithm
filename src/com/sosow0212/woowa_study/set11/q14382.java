package com.sosow0212.woowa_study.set11;

import java.util.Scanner;

public class q14382 {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solve());
        }
    }

    static String solve() {
        int answer = 0;

        int n = sc.nextInt();
        if (n == 0) {
            return "INSOMNIA";
        }

        boolean[] visited = new boolean[10];
        int countOfVisited = 0;

        for (int i = 1; ; i++) {
            int temp = n * i;

            for (String s : String.valueOf(temp).split("")) {
                int numberOfEachIndex = Integer.parseInt(s);
                if (!visited[numberOfEachIndex]) {
                    visited[numberOfEachIndex] = true;
                    countOfVisited++;
                }
            }

            if (countOfVisited == 10) {
                answer = temp;
                break;
            }
        }

        return String.valueOf(answer);
    }
}
