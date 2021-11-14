package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q1764 {
    static int n, m;
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> ans = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");

        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }


        Collections.sort(list);
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            binary_search(str);
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static void binary_search(String target) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid).equals(target)) {
                ans.add(target);
                return;
            }
            if (list.get(mid).compareTo(target) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }
}