package com.sosow0212.woowa_study.set7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q22233 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                if(set.contains(str)) {
                    set.remove(str);
                }
            }

            System.out.println(set.size());
        }
    }
}
