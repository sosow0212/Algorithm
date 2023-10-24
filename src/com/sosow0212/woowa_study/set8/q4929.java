package com.sosow0212.woowa_study.set8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int lengthA = Integer.parseInt(st.nextToken());

            if (lengthA == 0) {
                break;
            }

            int[] arr = new int[lengthA];
            for (int i = 0; i < lengthA; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int lengthB = Integer.parseInt(st.nextToken());
            int[] arr2 = new int[lengthB];
            for (int i = 0; i < lengthB; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int sumA = 0;
            int sumB = 0;
            int answer = 0;
            int i = 0;
            int j = 0;

            while (i < lengthA && j < lengthB) {
                if (arr[i] == arr2[j]) {
                    answer += Math.max(sumA, sumB);
                    answer += arr[i];
                    sumA = sumB = 0;
                    i++;
                    j++;
                } else if (arr[i] < arr2[j]) {
                    sumA += arr[i++];
                } else if (arr[i] > arr2[j]) {
                    sumB += arr2[j++];
                }
            }
            for (; i < lengthA; i++) {
                sumA += arr[i];
            }
            for (; j < lengthB; j++) {
                sumB += arr2[j];
            }
            answer += Math.max(sumA, sumB);
            sb.append(answer + "\n");
        }

        System.out.println(sb);
    }
}
