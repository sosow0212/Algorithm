package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16943 {

    static int[] a;
    static boolean[] selected;
    static int b;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = -1;

        char[] temp = st.nextToken().toCharArray();
        selected = new boolean[temp.length];
        a = new int[temp.length];
        b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < temp.length; ++i) {
            a[i] = temp[i] - '0';
        }

        permutation(0, 0, temp.length);

        System.out.println(ans);
    }

    private static void permutation(int number, int cnt, int max) {
        if (cnt == max) {
            ans = number > ans ? number : ans;
            return;
        }

        for (int i = 0; i < max; ++i) {
            if (selected[i] || (cnt == 0 && a[i] == 0)) {
                continue;
            }
            if (number * 10 + a[i] > b) {
                continue;
            }

            selected[i] = true;
            permutation(number * 10 + a[i], cnt + 1, max);
            selected[i] = false;
        }
    }
}
