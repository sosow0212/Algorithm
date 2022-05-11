package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q1269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int countA = 0;
        int countB = 0;

        HashMap<String, Integer> hashA = new HashMap<>();
        HashMap<String, Integer> hashB = new HashMap<>();

        for(int i=0; i<n; i++) {
            String str = sc.next();
            hashA.put(str, hashA.getOrDefault(str, 0) + 1);
        }

        for(int i=0; i<m; i++) {
            String str = sc.next();
            hashB.put(str, hashB.getOrDefault(str, 0) + 1);
        }

        int count = 0;
        for(String key : hashA.keySet()) {
            if(hashB.containsKey(key)) {
                count ++;
            }
        }
        countA = n - count;

        count = 0;

        for(String key : hashB.keySet()) {
            if(hashA.containsKey(key)) {
                count ++;
            }
        }

        countB = m - count;

        System.out.println(countA + countB);
    }
}
