package com.sosow0212.백준;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class q2992 {

    private static char[] arr;
    private static char[] now;
    private static boolean[] visited;
    private static Set<Integer> numberCombinations = new HashSet<>();
    private static String number;

    public static void main(String[] args) {
        initData();
        permutation(0, "");
        getAnswer();
    }

    private static void getAnswer() {
        List<Integer> answer = numberCombinations.stream()
                .sorted()
                .collect(Collectors.toList());

        int index = -1;
        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == Integer.parseInt(number)) {
                index = i;
            }
        }

        if (index == -1 || answer.size() - 1 == index) {
            System.out.println(0);
        } else {
            System.out.println(answer.get(index + 1));
        }
    }

    private static void initData() {
        Scanner sc = new Scanner(System.in);

        number = sc.next();
        arr = new char[number.length()];
        visited = new boolean[number.length()];
        now = new char[number.length()];

        for (int i = 0; i < number.length(); i++) {
            arr[i] = number.charAt(i);
        }
    }

    private static void permutation(int index, String permutationNumber) {
        if (index == number.length()) {
            numberCombinations.add(Integer.parseInt(permutationNumber));
            return;
        }

        for (int i = 0; i < number.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                now[index] = number.charAt(i);
                permutation(index + 1, permutationNumber + now[index]);
                visited[i] = false;
            }
        }
    }
}
