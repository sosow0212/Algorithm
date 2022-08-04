package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class q1343 {
    static StringBuilder sb = new StringBuilder();

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String s1 = br.readLine();
        int tempCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '.') {
                tempCount++;
                if (i == s1.length() - 1) {
                    if (!canSolve(tempCount)) {
                        System.out.println(-1);
                        return;
                    }
                    solve(tempCount);
                }
            } else {
                if (!canSolve(tempCount)) {
                    System.out.println(-1);
                    return;
                }
                solve(tempCount);
                tempCount = 0;
                sb.append(".");
            }
        }
        System.out.println(sb.toString());
    }

    public static void solve(int count) {
        if (count % 4 == 0) {
            for (int j = 0; j < count / 4; j++) {
                sb.append("AAAA");
            }
        } else {
            int ASize = count / 4;

            for (int j = 0; j < ASize; j++) {
                sb.append("AAAA");
            }
            int BSize = (count - ASize * 4) / 2;

            for (int j = 0; j < BSize; j++) {
                sb.append("BB");
            }
        }
    }

    public static boolean canSolve(int count) {
        if (count % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}