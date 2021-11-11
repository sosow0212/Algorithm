package com.sosow0212.백준;

import java.math.BigInteger;
import java.util.*;
import java.io.*;


public class q15489 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int pascal[][] = new int[30][30];
        pascal[0][0] = 1;
        for (int i = 1; i < 30; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    pascal[i][j] = 1;
                    continue;
                }
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        final int TOP_POINT_COL = Integer.parseInt(st.nextToken());
        final int TOP_POINT_ROW = Integer.parseInt(st.nextToken());
        final int TRI_SIDE_COUNT = Integer.parseInt(st.nextToken());
        int triGrade = 1;
        int addTotal = 0;
        for (int i = TOP_POINT_COL; i < TOP_POINT_COL + TRI_SIDE_COUNT; i++) {
            for (int j = TOP_POINT_ROW; j < TOP_POINT_ROW + triGrade; j++) {
                addTotal += pascal[i-1][j-1];
            }
            triGrade++;
        }

        sb.append(addTotal);
        sb.append("\n");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }


}