package com.sosow0212.백준;

import java.util.Scanner;

public class q5555 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        boolean[] check = new boolean[n];
        int ans = 0;

        for(int i=0; i<n; i++) {
            arr[i] = sc.next();
            arr[i] += arr[i];
            if(arr[i].contains(str)) {
                ans ++;
            }
        }

        System.out.println(ans);
    }
}
