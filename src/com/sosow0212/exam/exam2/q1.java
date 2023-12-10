package com.sosow0212.exam.exam2;

import java.util.ArrayList;
import java.util.List;

public class q1 {

    // xx_car

    private static boolean[] visited;
    private static List<List<Integer>> combinationOfBooks;

    public static int solution(int n, int[] orders) {
        long answer = Long.MAX_VALUE;

        combinationOfBooks = new ArrayList<>();
        visited = new boolean[n + 1];
        makeCombinationOfBooks(n, new ArrayList<>());

        for (List<Integer> books : combinationOfBooks) {
            long power = getPowerWhenTakingBooks(orders, books);
            answer = Math.min(answer, power);
        }

        return (int) answer % 1_000_000_000;
    }

    public static void makeCombinationOfBooks(int bookSize, List<Integer> books) {
        if (books.size() == bookSize) {
            insertBooksCombination(books);
            return;
        }

        for (int book = 1; book <= bookSize; book++) {
            if (!visited[book]) {
                visited[book] = true;
                books.add(book);
                makeCombinationOfBooks(bookSize, books);
                books.remove(books.size() - 1);
                visited[book] = false;
            }
        }
    }

    private static void insertBooksCombination(final List<Integer> books) {
        List<Integer> result = new ArrayList<>();

        for (Integer book : books) {
            result.add(book);
            result.add(book);
        }

        combinationOfBooks.add(new ArrayList<>(result));
    }

    private static long getPowerWhenTakingBooks(final int[] orders, final List<Integer> books) {
        long power = 0;

        for (int i = 0; i < orders.length; i++) {
            int bookOrder = orders[i];
            int indexOfBookOrder = books.indexOf(bookOrder);
            power += indexOfBookOrder;
            books.remove(indexOfBookOrder);
        }

        return power;
    }

    public static void main(String[] args) {
        // 3
        System.out.println(solution(3, new int[]{1, 2, 1, 3, 3, 2}));

        // 0
        System.out.println(solution(4, new int[]{3, 3, 2, 2, 1, 1, 4, 4}));
    }
}
