package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> qu = new LinkedList<Integer>();
        for(int i = 0; i < N; i++) { // 큐에 N까지의 수 차례로 넣어주기
            qu.add(i+1);
        }

        while(!qu.isEmpty()) { // N명의 사람이 모두 제거될 때까지, 즉 큐가 빌 때까지 반복
            for(int j = 0; j < K; j++) { // K번째를 제거하기 위한 루프
                if(j == K-1) {
                    sb.append(qu.poll() + ", "); // K번을 제거
                } else {
                    qu.add(qu.poll()); // K번이 아닐 때에는 맨 뒤로 이동
                }
            }
        }

        bw.write((sb.substring(0, sb.length()-2) + ">").toString());
        bw.flush();
        bw.close();
    }
}