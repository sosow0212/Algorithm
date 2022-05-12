package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int[] books = new int[N];

        if(N == 0){
            System.out.println(0);
            return;
        }

        stringTokenizer = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N ; i++){
            books[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int box = 1;
        int weight = 0;

        for(int i = 0 ; i < N; i++){
            weight += books[i];
            if(weight > M){
                box++;
                weight = books[i];
            }
        }

        System.out.println(box);

    }
}