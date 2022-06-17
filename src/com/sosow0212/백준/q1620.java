package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<String, String> StringNumberHash = new HashMap<>();
        HashMap<String, String> NumberStringHash = new HashMap<>();

        for(int i=1; i<=n; i++) {
            String name = sc.next();
            StringNumberHash.put(name, String.valueOf(i));
            NumberStringHash.put(String.valueOf(i), name);
        }

        for(int i=0; i<k; i++) {
            String ans = sc.next();
            if(StringNumberHash.containsKey(ans)) {
                System.out.println(StringNumberHash.get(ans));
            } else {
                System.out.println(NumberStringHash.get(ans));
            }
        }
    }
}
