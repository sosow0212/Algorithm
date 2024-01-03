package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q2002 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        HashMap<String, Integer> in = new HashMap<>();

        for (int i = 0; i < n; i++) {
            in.put(sc.next(), i);
        }

        for (int i = 0; i < n; i++) {
            String out = sc.next();

            for (String key : in.keySet()) {
                if (in.get(out) > in.get(key)) {
                    answer++;
                    break;
                }
            }

            in.remove(out);
        }

        System.out.println(answer);
    }

    /**
     * a b c d
     * d c a b
     */

}
