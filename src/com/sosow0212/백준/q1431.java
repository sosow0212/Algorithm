package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class q1431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() < o2.length() ? -1 : 1;
                }

                if (o1.length() == o2.length()) {
                    int sum1 = 0;
                    int sum2 = 0;

                    for (char ch : o1.toCharArray()) {
                        if (ch >= 'A') {
                            continue;
                        }
                        sum1 += ch - '0';
                    }
                    for (char ch : o2.toCharArray()) {
                        if (ch >= 'A') {
                            continue;
                        }
                        sum2 += ch - '0';
                    }

                    if (sum1 < sum2) {
                        return -1;
                    }
                    if (sum1 > sum2) {
                        return 1;
                    }
                }

                for (int i = 0; i < o1.length(); i++) {

                    if (o1.charAt(i) < o2.charAt(i)) {
                        return -1;
                    }
                    if (o1.charAt(i) > o2.charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            }
        };

        list.stream()
                .sorted(comparator)
                .forEach(i -> System.out.println(i));
    }
}
