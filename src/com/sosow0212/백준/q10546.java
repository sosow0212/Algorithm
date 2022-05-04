package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q10546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "";

        String[] all = new String[n];
        String[] done = new String[n-1];

        for(int i=0; i<n; i++) {
            all[i] = sc.next();
        }

        for(int i=0; i<n-1; i++) {
            done[i] = sc.next();
        }

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String s : all) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        for (String s : done) {
            hashMap.put(s, hashMap.get(s) - 1);
        }

        for(String s : all) {
            if(hashMap.get(s) == 1) {
                ans = s;
            }
        }

        System.out.println(ans);
    }
}
