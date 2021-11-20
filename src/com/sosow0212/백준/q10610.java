package com.sosow0212.백준;

import java.util.Arrays;
import java.util.Scanner;

public class q10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int[] arr = new int[n.length()];
        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            arr[i] = n.charAt(i) - '0';
            sum += n.charAt(i) - '0';
        } // arr에 n(String) 을 하나하나씩 넣었음

        Arrays.sort(arr);

        if(arr[0] == 0 && sum % 3 ==0) {
            for(int i=arr.length-1; i>=0; i--)
                System.out.print(arr[i]);
        }
        else
            System.out.println(-1);
    }
}
