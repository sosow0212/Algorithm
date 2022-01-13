package com.sosow0212.백준;

import java.io.*;

public class q2526 {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int P = Integer.parseInt(str1[1]);
        int idx = 0;
        int temp = N;
        int arr[] = new int[P + 1];
        boolean isFound = false;
        while (!isFound) {
            temp = N * temp % P;
            for (int i = 0; i < idx; i++) {
                if (arr[i] == temp) {
                    isFound = true;
                    bw.write(String.valueOf(idx - i));
                    break;
                }
            }
            arr[idx] = temp;
            idx++;
        }
        bw.flush();
    }
}