package com.sosow0212.백준;

import java.util.*;
// 회의실배정 - 그리디 / 어려움

public class q1931 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        // 0번 인덱스 기준 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 1번 인덱스 기준 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int end_time = 0;

        // 시작시간이 endtime보다 크거나 같으면 endtime을 그 행의 끝나는 시간으로 두고 count 증가.
        for(int i=0; i<n; i++) {
            if(arr[i][0] >= end_time) {
                end_time = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
