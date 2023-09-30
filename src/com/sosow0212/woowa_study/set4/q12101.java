package com.sosow0212.woowa_study.set4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12101 {

    static int n;
    static int k;
    static int[] answers = new int[11];
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        permutation(0, 0);

        if (count != k) {
            System.out.println(-1);
        }
    }

    static boolean permutation(int sum, int index) {
        if (sum > n) {
            return false;
        }

        if (sum == n) {
            count++;

            if (count == k) {
                for (int i = 0; i < index - 1; i++) {
                    System.out.print(answers[i] + "+");
                }

                System.out.print(answers[index - 1]);
                return true;
            }
        }

        for (int i = 1; i <= 3; i++) {
            answers[index] = i;
            if (permutation(sum + i, index + 1)) {
                return true;
            }
        }

        return false;
    }
}
