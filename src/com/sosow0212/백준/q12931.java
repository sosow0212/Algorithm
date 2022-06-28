package com.sosow0212.백준;

import java.io.*;
import java.util.StringTokenizer;

public class q12931 {
    static int answer, mul;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            bitCountFunc(Integer.parseInt(str.nextToken()));
        }
        answer += mul;

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }

    static void bitCountFunc(int n) {
        String bStr = Integer.toBinaryString(n);
        int bitCount = Integer.bitCount(n);
        mul = Math.max(mul, bStr.length() - 1);
        answer += bitCount;
    }
}