package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class q2204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        HashMap<String, String> hashMap = new HashMap<>();

        while (input != 0) {
            String[] arr = new String[input];
            for (int i = 0; i < input; i++) {
                arr[i] = sc.next();
            }
            for (int i = 0; i < arr.length; i++) {
                String temp = arr[i].toLowerCase();
                hashMap.put(temp, arr[i]);
                arr[i] = arr[i].toLowerCase();
            }
            Arrays.sort(arr);
            System.out.println(hashMap.get(arr[0]));
            input = sc.nextInt();
        }
    }
}
