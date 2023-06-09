package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.Scanner;

public class q25206 {

    public static void main(String[] args) {
        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        Scanner sc = new Scanner(System.in);
        double sum = 0;
        double subject = 0;
        double v = 0;

        for (int i = 0; i < 20; i++) {
            String str = sc.nextLine();
            String[] sub = str.split(" ");

            if (!sub[2].equals("P")) {
                v += map.get(sub[2]) * Double.parseDouble(sub[1]);
                subject += Double.parseDouble(sub[1]);
            }
        }

        double answer = v / subject;
        System.out.print(String.format("%.6f", answer));
    }
}
