package com.sosow0212.selfStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char[] arr = {'U', 'C', 'P', 'C'};
        int idx = 0;

        for (int i = 0; i < str.length(); i++) {

            if (arr[idx] == str.charAt(i)) {
                idx++;
            }
            if (idx == 4) {
                break;
            }
        }
        System.out.printf(idx == 4 ? "love" : "hate");


    }
}
