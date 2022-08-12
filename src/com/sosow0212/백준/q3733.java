package com.sosow0212.백준;

import java.util.Scanner;

public class q3733 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, s;
        while(sc.hasNext()){
            n = sc.nextInt();
            s = sc.nextInt();
            System.out.println(s/(n+1));
        }
    }
}