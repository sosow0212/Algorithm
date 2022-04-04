package com.sosow0212.백준;

import java.io.*;
import java.util.*;

public class q4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tree;
        TreeMap<String, Integer> map = new TreeMap<>();
        double cnt = 0;
        while ((tree = br.readLine()) != null) {
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (var t : map.entrySet()) {
            sb.append(t.getKey())
                    .append(" ")
                    .append(String.format("%.4f", t.getValue() / cnt * 100))
                    .append("\n");
        }
        System.out.println(sb);
    }
}