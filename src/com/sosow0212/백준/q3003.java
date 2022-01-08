package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q3003 {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[6];
        int P[] = {1,1,2,2,2,8};
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<6;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<6;i++) {
            bw.write(String.valueOf(Math.subtractExact(P[i], arr[i])+" "));
            bw.flush();
        }
        bw.close();
    }
}
