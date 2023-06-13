package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

    public int[] solution(String[] operations) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Queue<Integer> pqDec = new PriorityQueue<>(Comparator.reverseOrder());

        for (String op : operations) {
            String command = op.split(" ")[0];
            String order = op.split(" ")[1];

            if (command.equals("I")) {
                int temp = Integer.parseInt(order);
                pqDec.add(temp);
                continue;
            }

            if (command.equals("D") && pqDec.size() >= 1) {

                if (order.equals("1")) {
                    pqDec.poll();
                } else {
                    Queue<Integer> upQueue = new PriorityQueue<>();
                    upQueue.addAll(pqDec);
                    upQueue.poll();

                    pqDec.clear();
                    pqDec.addAll(upQueue);
                }
            }
        }

        if (pqDec.size() == 0) {
            return new int[]{0, 0};
        }

        while (pqDec.size() > 0) {
            int q = pqDec.poll();
            max = Math.max(max, q);
            min = Math.min(min, q);
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        이중우선순위큐 sol = new 이중우선순위큐();

        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations1 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        // 0, 0
        System.out.println(Arrays.toString(sol.solution(operations)));

        // 333, -45
        System.out.println(Arrays.toString(sol.solution(operations1)));
    }
}
