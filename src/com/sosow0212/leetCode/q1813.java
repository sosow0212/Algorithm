package com.sosow0212.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1813 {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> dq1 = new ArrayDeque<>();
        Deque<String> dq2 = new ArrayDeque<>();

        for (String s : sentence1.split(" ")) {
            dq1.addLast(s);
        }

        for (String s : sentence2.split(" ")) {
            dq2.addLast(s);
        }

        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }

        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }

        return dq1.isEmpty() || dq2.isEmpty();
    }
}