package com.sosow0212.백준;

import java.util.LinkedList;
import java.util.Scanner;

public class q10845 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            String command = scanner.next();
            switch (command) {
                case "push":
                    int x = scanner.nextInt();
                    queue.add(x);
                    break;
                case "pop":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.removeFirst());
                    break;
                case "empty":
                    if (queue.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "front":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.getFirst());
                    break;
                case "back":
                    if (queue.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(queue.getLast());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
            }
        }
    }
}
