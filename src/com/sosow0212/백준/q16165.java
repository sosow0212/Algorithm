package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class q16165 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String group = sc.next();
            map.put(group, new ArrayList<>());
            int person = sc.nextInt();

            for (int j = 0; j < person; j++) {
                String name = sc.next();
                List<String> groups = map.get(group);
                groups.add(name);
            }
        }

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            int ch = sc.nextInt();

            if (ch == 1) {
                // 멤버 이름 -> 멤버 팀
                for (String s : map.keySet()) {
                    if (map.get(s).contains(name)) {
                        System.out.println(s);
                        break;
                    }
                }
            } else {
                // 팀 이름 -> 멤버이름 사전 순
                List<String> groups = map.get(name);
                Collections.sort(groups);

                for (String group : groups) {
                    System.out.println(group);
                }
            }
        }
    }
}
