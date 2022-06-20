package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q12851 {

    static int n, k;
    static int[] time = new int[100001];
    static int min = Integer.MAX_VALUE;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        if(n >= k) {
            System.out.println((n-k));
            System.out.println(1);
            return;
        }

        bfs();

        System.out.println(min);
        System.out.println(count);


    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        time[n] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(time[now] > min)
                return;

            for(int i=0; i<3; i++) {
                // 3가지 경우 처리
                int next;

                if(i==0)
                    next = now + 1;
                else if(i==1)
                    next = now - 1;
                else
                    next = now * 2;

                if(next > 100000 || next < 0) // 잘못된 경우
                    continue;

                if(next == k) { // 정답인 경우
                    min = time[now];
                    count++;
                }

                if(time[next] == 0 || time[next] == time[now] + 1) { // 처음 + 재방/문
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }

    }
}
