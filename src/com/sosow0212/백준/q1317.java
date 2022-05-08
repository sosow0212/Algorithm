package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1317 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for (int t = 0; t < test; t++) {

            int n = sc.nextInt();
            List<String> arr = new ArrayList<>();
            String firstWord = sc.next();
            arr.add(0, firstWord);

            for (int i = 0; i < n - 1; i++) {
                String first = arr.get(0);
                String last = arr.get(arr.size() - 1);
                String temp = sc.next();

                int num_first = first.charAt(0) - '0';
                int num_last = last.charAt(0) - '0';
                int num_temp = temp.charAt(0) - '0';

                if (num_temp >= num_last || (num_temp < num_last && num_temp > num_first)) {
                    arr.add(arr.size(), temp);
                } else {
                    arr.add(0, temp);

                }
            }

            String ans = "";
            for (String str : arr) {
                ans += str;
            }
            System.out.println(ans);

        }
    }
}
