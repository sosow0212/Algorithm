package com.sosow0212.selfStudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class greedyGo {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr = br.readLine();
        char[] UCPC = {'U', 'C', 'P', 'C'};
        int idx = 0;

        for (int i = 0; i < arr.length(); i++) {
            if (UCPC[idx] == (arr.charAt(i))) {
                idx++;
            }
            if (idx == 4) {
                break;
            }
        }

        System.out.println(idx == 4 ? "love" : "hate");
    }
}