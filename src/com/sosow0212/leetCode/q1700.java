package com.sosow0212.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class q1700 {

    public int countStudents(int[] st, int[] sa) {
        Deque<Integer> student = new ArrayDeque<>();
        Deque<Integer> sand = new ArrayDeque<>();

        for (int i = 0; i < sa.length; i++) {
            sand.add(sa[i]);
        }

        for (int i = 0; i < st.length; i++) {
            student.add(st[i]);
        }

        int count = 0;
        while (true) {
            if (count == student.size() || student.isEmpty()) {
                break;
            }

            int man = student.pollFirst();

            if (man == sand.peekFirst()) {
                sand.pollFirst();
                count = 0;
            } else {
                student.addLast(man);
                count++;
            }
        }

        return student.size();
    }
}
