package com.sosow0212.프로그래머스;

import java.util.HashSet;
import java.util.Set;

class 연속부분수열 {
    public int solution(int[] elements) {
//        int[] copies = new int[elements.length * 2];
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < copies.length; i++) {
//            if (i < elements.length) {
//                copies[i] = elements[i];
//            } else {
//                copies[i] = elements[i - elements.length];
//            }
//        }
//
//        for (int i = 1; i <= elements.length; i++) {
//            for (int j = 0; j < elements.length; j++) {
//                set.add(copies[j + 1] - copies[j]);
//            }
//        }
//
//
//        return set.size();


        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int[] copies = new int[elements.length * 2];

        for (int i = 1; i < elements.length * 2; i++) {
            sum += elements[(i - 1) % elements.length];
            copies[i] = sum;
        }

        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(copies[j + i] - copies[j]);
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        연속부분수열 sol = new 연속부분수열();

        int[] arr = {7, 9, 1, 1, 4};

        // 18
        System.out.println(sol.solution(arr));
    }
}
