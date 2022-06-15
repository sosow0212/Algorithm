package com.sosow0212.백준;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class q5052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int t = 0; t < test; t++) {
            int n = sc.nextInt();
            HashMap<String, String> hashMap = new HashMap<>();
            String[] arr = new String[n];
            boolean check = false;

            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            Arrays.sort(arr);

            for (String num : arr) {
                hashMap.put(num, "");
            } // 정렬된 전화번호 넣기

            for (String str : arr) {
                for (int i = 0; i < str.length(); i++) {
                    if (hashMap.containsKey(str.substring(0, i))) {
                        check = true;
                    }
                }
            }

            if (check) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
