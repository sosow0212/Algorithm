package com.sosow0212.백준;

import java.util.ArrayList;
import java.util.List;

public class backTest {

    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) {
        visited = new boolean[5];
        arr = new int[5];

        for (int i = 1; i <= 5; i++) {
            arr[i - 1] = i;
        }

        permutation(0, new ArrayList<>());
    }

    static void permutation(int index, List<Integer> list) {
        System.out.println(list);

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);
                permutation(index + 1, list);
                list.remove(Integer.valueOf(arr[i]));
                visited[i] = false;
            }
        }
    }
}
