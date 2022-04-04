package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        HashMap<String, Integer> hashMap1 = new HashMap();
        String[] list = new String[m];

        for(int i=0; i<n; i++) {
            String str = sc.next();
            hashMap1.put(str, 0);
        }

        for(int i=0; i<m; i++) {
            list[i] = sc.next();
        }

        for(String str : list) {
            if(hashMap1.containsKey(str)) {
                count ++;
            }
        }
        System.out.println(count);

    }
}
