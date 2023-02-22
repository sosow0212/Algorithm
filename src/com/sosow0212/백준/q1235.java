package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class q1235 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Set<String> set = new HashSet<>();

        String[] input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = in.readLine();
        }
        int len = input[0].length();

        for (int k = 1; k <= len; k++) {
            for (int i = 0; i < N; i++) {
                set.add(input[i].substring(len - k));
            }
            if (set.size() == N) {
                System.out.println(k);
                return;
            }
            set.clear();
        }
    }
}
