package com.sosow0212.백준;

import java.io.*;

public class q2553 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[20001];

        arr[1] = 1;
        for (int i = 2; i <= 4; i++) {
            arr[i] = arr[i - 1] * i;
        } // 4까지

        //1, 2, 6, 24, 120, 720(6)
        // 5^a * b! 형태로 만들기

        for (int i = 5; i <= n; i++) {
            if (i % 5 == 0) {
                int q = i / 5;
                arr[i] = ((int) Math.pow(2, q % 4) * arr[q]) % 10; // i > 5의 배수 인 숫자
            } else {
                int bNum = (i / 5) * 5; // i보다 작은 최대 5의 배수를 구함.
                int total = 1;
                for (int j = i; j > bNum; j--) {
                    total *= (j % 10);
                }
                total *= arr[bNum];
                arr[i] = total % 10;
            }
        }

        bw.write(arr[n] + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
