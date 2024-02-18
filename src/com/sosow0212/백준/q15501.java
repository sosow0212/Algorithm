package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class q15501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        Map<Integer, List<Integer>> map1 = new HashMap<>();
        Map<Integer, List<Integer>> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
            map1.put(arr1[i], new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
            map2.put(arr2[i], new ArrayList<>());
        }

        for (int i = 0; i < arr1.length; i++) {
            if (i == 0) {
                map1.get(arr1[i]).add(arr1[i + 1]);
                map1.get(arr1[i]).add(arr1[arr1.length - 1]);
                map2.get(arr2[i]).add(arr2[i + 1]);
                map2.get(arr2[i]).add(arr2[arr2.length - 1]);
            } else if (i == arr1.length - 1) {
                map1.get(arr1[i]).add(arr1[0]);
                map1.get(arr1[i]).add(arr1[arr1.length - 2]);
                map2.get(arr2[i]).add(arr2[0]);
                map2.get(arr2[i]).add(arr2[arr2.length - 2]);
            } else {
                map1.get(arr1[i]).add(arr1[i - 1]);
                map1.get(arr1[i]).add(arr1[i + 1]);
                map2.get(arr2[i]).add(arr2[i - 1]);
                map2.get(arr2[i]).add(arr2[i + 1]);
            }

            Collections.sort(map1.get(arr1[i]));
            Collections.sort(map2.get(arr2[i]));
        }

        if (map1.equals(map2)) {
            System.out.println("good puzzle");
        } else {
            System.out.println("bad puzzle");
        }
    }
}
