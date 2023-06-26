package com.sosow0212.백준;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q1781 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Question[] questions = new Question[n];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            int deadLine = sc.nextInt();
            int ramen = sc.nextInt();
            questions[i] = new Question(ramen, deadLine);
        }

        Arrays.sort(questions);

        for (Question question : questions) {
            int size = pq.size();

            if (size < question.deadLine) {
                pq.offer(question.ramen);
                continue;
            }

            if (size == question.deadLine && question.ramen > pq.peek()) {
                pq.poll();
                pq.offer(question.ramen);
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }

    private static class Question implements Comparable<Question> {
        private int ramen;
        private int deadLine;

        public Question(final int ramen, final int deadLine) {
            this.ramen = ramen;
            this.deadLine = deadLine;
        }

        // deadLine 오름차순, 컵라면 내림차순
        @Override
        public int compareTo(final Question o) {
            if (o.deadLine == this.deadLine) {
                return o.ramen - this.ramen;
            }

            return this.deadLine - o.deadLine;
        }
    }
}
