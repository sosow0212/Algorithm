package com.sosow0212.백준;

import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class q5893 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int N = Integer.parseInt(str[0]);
        String N = br.readLine();

        BigInteger big = new BigInteger("0");
        for (int i = 0; i < N.length(); i++) {
            if (N.charAt(i) == '1') {
                big = big.add(new BigInteger("2").pow(N.length()-(i+1)));
            } else if (N.charAt(i) == '0'){
                big = big.add(new BigInteger("0"));
            } else if (N == "0") {
                bw.write(String.valueOf("0"));
            }
        }
        BigInteger result = big.multiply(new BigInteger("17"));
        String last = "";
        while (result != BigInteger.valueOf(0)) {
            last += result.mod(BigInteger.valueOf(2)); // 선언된 String에 이어 붙인다.
            result = result.divide(BigInteger.valueOf(2)); // 나머지를 구하여 result에 다시 저장함으로써 0이 될때까지 반복한다.
        }
        for (int i = last.length()-1; i >= 0; i--) {
            bw.write(String.valueOf(last.charAt(i))); //거꾸로 뒤집어 출력한다.
        }

        bw.flush();
        br.close();
        bw.close();
    }
}