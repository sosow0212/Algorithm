package com.sosow0212.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class q1837 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static BigInteger P, K;
    static boolean sosuchk[] = new boolean[1000001];
    static Set<BigInteger> sosu = new TreeSet<>();
    static int k;

    static void func() {
        Iterator<BigInteger> iter = sosu.iterator();
        while (iter.hasNext()) {
            BigInteger a = iter.next();
            if (a.compareTo(K) >= 0)
                break;

            if (P.mod(a).equals(new BigInteger("0"))) {
                System.out.println("BAD " + a);
                return;
            }
        }

        System.out.println("GOOD");
    }

    static void init() {
        for (int i = 2; i <= 1000000; i++) {
            if (sosuchk[i])
                continue;

            sosu.add(new BigInteger(Integer.toString(i)));
            for (int j = 2; i * j <= 1000000; j++) {
                if (sosuchk[i * j])
                    continue;

                sosuchk[i * j] = true;
            }
        }
    }

    static void input() throws Exception {
        st = new StringTokenizer(br.readLine());

        P = new BigInteger(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        K = new BigInteger(Integer.toString(k));
    }

    public static void main(String[] args) throws Exception {
        init();
        input();
        func();
    }
}