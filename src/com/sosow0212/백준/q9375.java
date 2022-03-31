package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class q9375 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int ans = 1;
            int n = sc.nextInt();
            HashMap<String, Integer> hashMap = new HashMap<>();

            for(int i=0; i<n; i++) {
                String a = sc.next();
                String b = sc.next();
//                hashMap.put(b , hashMap.getOrDefault(hashMap.get(b), 0) + 1);

                if(hashMap.containsKey(b)) {
                    int index = hashMap.get(b);
                    hashMap.put(b, index + 1);
                } else {
                    hashMap.put(b, 1);
                }
            }

            for(int val : hashMap.values()) {
                ans *= val + 1;
            }

            System.out.println(ans - 1);
        }
    }
}
