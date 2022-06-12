package com.sosow0212.백준;

import java.util.*;
import java.io.*;

public class q20437 {
    static int tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        tc = stoi(br.readLine());

        while (tc-- != 0) {
            int[] alpha = new int[26];
            String str = br.readLine();
            int k = stoi(br.readLine());
            int len = str.length();
            // 현재 문자열의 알파벳 개수를 센다.
            for (int i = 0; i < len; i++) {
                alpha[str.charAt(i) - 'a']++;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                int curC = str.charAt(i);
                if (alpha[curC - 'a'] < k)    // k개 미만인 문자일 경우 탐색할 필요가 없다
                    continue;
                int count = 0;

                for (int j = i; j < len; j++) {
                    if (curC == str.charAt(j)) {
                        count++;
                    }
                    // 어떤 문자를 정확히 K개를 포함
                    if (count == k) {
                        min = Math.min(min, j - i + 1);    // 가장 짧은 연속 문자열의 길이
                        max = Math.max(max, j - i + 1); // 가장 긴 연속 문자열의 길이
                        break;
                    }
                }
            }

            if (min != Integer.MAX_VALUE) {
                System.out.print(min + " ");
                System.out.println(max);
            } else
                System.out.println(-1);
        }
        br.close();
    }

    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}