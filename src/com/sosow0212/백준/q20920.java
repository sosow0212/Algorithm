package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q20920 {
    static int N, M;
    static ArrayList<String> words = new ArrayList<String>();
    static HashMap<String, Integer> map = new HashMap<String, Integer>(M);

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int n = 0; n < N; n++) {
            String w = br.readLine();
            if (w.length() < M) {
                continue;
            }
            if (map.get(w) == null) {
                words.add(w);
                map.put(w, 1);
            } else {
                map.replace(w, map.get(w) + 1);
            }
        }

        // 정렬
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int c1 = map.get(o1);
                int c2 = map.get(o2);
                if (c1 == c2) {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    if (o1.length() > o2.length()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                if (c1 > c2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < words.size(); m++) {
            sb.append(words.get(m) + "\n");
        }
        System.out.println(sb);

    }

}