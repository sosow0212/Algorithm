package com.sosow0212.codeUp;

import java.util.Arrays;
import java.util.Scanner;

public class q2633 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int ans = 0;
        boolean visit = false;

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();

            if(arr[i] >= k && visit == false) {
                visit = true;
                ans = i;
            }//
        }

        if(visit == false) {
            System.out.println(n+1);
        } else {
            System.out.println(ans + 1);
        }



    }
}
