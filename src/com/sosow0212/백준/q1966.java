package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q1966 {
    static int tc;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            StringTokenizer str = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();

            for (int j = 0; str.hasMoreTokens(); j++) {
                q.add(new int[]{j, Integer.parseInt(str.nextToken())});
            }

            int count = 0;
            while (!q.isEmpty()) {
                int[] temp = q.poll();
                boolean check = true;
                for (int j = 0; j < q.size(); j++) {
                    if (temp[1] < q.get(j)[1]) {
                        q.add(temp);

                        for (int k = 0; k < j; k++)
                            q.add(q.poll());

                        check = false;
                        break;
                    }
                }
                if (check == false)
                    continue;
                count++;
                if (temp[0] == M)
                    break;

            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}