package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q17219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String site = sc.next();
            String pw = sc.next();

            hashMap.put(site, pw);
        }

        for(int i=0; i<m; i++) {
            String find = sc.next();
            System.out.println(hashMap.get(find));
        }
    }
}
