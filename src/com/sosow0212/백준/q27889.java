package com.sosow0212.백준;

import java.util.Map;
import java.util.Scanner;

public class q27889 {

    public static void main(String[] args) {
        Map<String, String> map = Map.of(
                "NLCS", "North London Collegiate School",
                "BHA", "Branksome Hall Asia",
                "KIS", "Korea International School",
                "SJA", "St. Johnsbury Academy"
        );

        Scanner sc = new Scanner(System.in);
        System.out.println(map.get(sc.next()));
    }
}
