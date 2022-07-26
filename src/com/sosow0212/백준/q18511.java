package com.sosow0212.백준;

import java.util.*;
import java.io.*;

public class q18511 {
    static int chan(String str) {
        return Integer.parseInt(str);
    }

    static String arr[];
    static boolean visit[];
    static Set<String> set = new HashSet<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        String sstr = st.nextToken();   //숫자의 길이를 알기 위해 먼저 String으로 받음
        int N = chan(sstr);

        int K = chan(st.nextToken());

        arr = new String[K];
        visit = new boolean[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = st.nextToken();
        }
        ///////////////////////////////////////////////////////입력 끝

        perm1("", 0, sstr.length());
        perm2("", 0, sstr.length() - 1);

        for (String ss : set) {
            al.add(chan(ss));
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < al.size(); i++) {
            int value = al.get(i);
            if (value >= max && value <= N) max = value;
        }
        System.out.print(max);
    }

    //같은 자리 숫자일 때
    static void perm1(String str, int count, int limit) {
        if (limit == count) {
            set.add(str);
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            visit[i] = true;
            perm1(str + arr[i], count + 1, limit);
            visit[i] = false;
        }
    }

    // 자리 수 - 1 까지 해줘야함.
    static void perm2(String str, int count, int limit) {
        if (limit == count) {
            set.add(str);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            visit[i] = true;
            perm2(str + arr[i], count + 1, limit);
            visit[i] = false;
        }
    }
}