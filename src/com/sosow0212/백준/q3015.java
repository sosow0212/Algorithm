package com.sosow0212.백준;

import java.util.Scanner;
import java.util.Stack;

public class q3015 {

    private static Scanner scanner = new Scanner(System.in);
    static int n;
    static long answer = 0;

    static class Player {
        int height, count;

        public Player(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        n = scanner.nextInt();
        Stack<Player> stack = new Stack<>();

        while (n-- > 0) {
            int now = scanner.nextInt();

            while (!stack.isEmpty() && stack.peek().height < now) {
                answer += stack.pop().count;
            }

            int temp = 0;
            if (!stack.isEmpty() && stack.peek().height == now) {
                temp = stack.pop().count;
                answer += temp;
            }

            if (!stack.isEmpty()) {
                answer++;
            }

            stack.add(new Player(now, temp + 1));
        }

        System.out.println(answer);
    }
}
