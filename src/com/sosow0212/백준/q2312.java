package com.example.shoppingmall.web;

import java.io.*;
import java.util.*;

public class q2312 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[100001];
            for(int j = 2; j * j <= N; j++){
                if(N % j == 0){
                    N /= j;
                    arr[j]++;
                    j--;
                }
            }
            if(N > 1) {
                arr[N]++;
            }
            for(int j = 1; j <= 100000; j++){
                if(arr[j] != 0){
                    bw.write(j + " " + arr[j] + "\n");
                }
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}