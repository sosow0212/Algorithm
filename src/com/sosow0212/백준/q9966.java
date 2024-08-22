package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q9966 {

    static final String YES = "DA";
    static final String NO = "NE";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String pattern = sc.next();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.next());
        }

        int indexOfStar = pattern.indexOf('*');
        String prefix = pattern.substring(0, indexOfStar);
        String suffix = pattern.substring(indexOfStar + 1);
        for (String s : list) {
            if (s.startsWith(prefix) && s.endsWith(suffix) && s.length() >= prefix.length() + suffix.length()) {
                System.out.println(YES);
            } else {
                System.out.println(NO);
            }
        }
    }
}
