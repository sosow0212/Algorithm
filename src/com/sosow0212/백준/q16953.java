package com.sosow0212.백준;

import java.util.*;

public class q16953 {
    public static long A;
    public static long B;
    public static long ans = 1000;
    public static boolean check = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        DFS(A, 1);
        if(!check) ans = -1;
        System.out.println(ans);
    }

    // DFS
    public static void DFS(long num, int level) {
        if(num == B) {
            ans = Math.min(ans,  level);
            check = true;
            return;
        }
        if(num > B) {
            return;
        }
        DFS(num*10+1, level+1);
        DFS(num*2, level+1);
    }

}