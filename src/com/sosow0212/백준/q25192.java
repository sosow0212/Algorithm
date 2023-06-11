package com.sosow0212.백준;

import java.util.HashMap;
import java.util.Scanner;

public class q25192 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();

            if (str.equals("ENTER")) {
                answer += map.keySet().size();
                map.clear();
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }

        }
        answer += map.keySet().size();

        System.out.println(answer);
    }
}
