package com.sosow0212.exam.exam1.exam2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class q4 {

    public List<String> solution(int maxSize, String[] actions) {
        Stack<String> front = new Stack<>();
        Stack<String> back = new Stack<>();
        Queue<String> visitedList = new LinkedList<>();

        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];
            System.out.println(action);

            if (action.equals("B")) {
                if (back.isEmpty()) {
                    continue;
                }

                String now = visitedList.peek();
                visitedList.add(back.pop());
                front.add(now);

            } else if (action.equals("F")) {
                if (front.isEmpty()) {
                    continue;
                }

                String now = visitedList.peek();
                String frontPage = front.pop();
                visitedList.add(frontPage);
                back.add(now);

            } else {
                if (visitedList.isEmpty()) {
                    visitedList.add(action);
                } else {
                    String now = visitedList.peek();
                    back.push(now);
                    visitedList.add(action);
                }
            }
        }

        System.out.println(visitedList);

        return null;
    }

    public static void main(String[] args) {
        q4 sol = new q4();

        int maxSize = 3;
        String[] actions = {"1", "3", "2", "B", "4", "F"};

        // 5, 4, 3
        System.out.println(sol.solution(maxSize, actions));
    }
}
