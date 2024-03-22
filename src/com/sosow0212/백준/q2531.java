package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = bf.readLine().split(" ");

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(str[0]);
        int d = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);
        int c = Integer.parseInt(str[3]);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();

            int left = i;
            int right = (left + k - 1) % n;

            if (left > right) {
                for (int j = left; j < n; j++) {
                    set.add(arr[j]);
                }

                for (int j = 0; j <= right; j++) {
                    set.add(arr[j]);
                }
            } else {
                for (int j = left; j <= right; j++) {
                    set.add(arr[j]);
                }
            }

            set.add(c);

            answer = Math.max(answer, set.size());
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }
}
