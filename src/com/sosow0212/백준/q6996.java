package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q6996 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            anagram(a, b);
        }
    }

    public static void anagram(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2))
            System.out.println(str1 + " & " + str2 + " are anagrams.");
        else
            System.out.println(str1 + " & " + str2 + " are NOT anagrams.");
    }
}
