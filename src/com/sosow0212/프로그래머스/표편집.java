package com.sosow0212.프로그래머스;

import java.util.Map;
import java.util.Stack;

public class 표편집 {

    static Map<String, Integer> moveCommand = Map.of(
            "D", 1,
            "U", -1
    );

    public static String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> indexUndo = new Stack<>(); // [index]

        int size = n;

        for (String c : cmd) {
            if (c.equals("C")) {
                indexUndo.push(k);
                size--;

                if (k == size) {
                    k--;
                }

            } else if (c.equals("Z")) {
                Integer index = indexUndo.pop();

                if (index <= k) {
                    k++;
                }

                size++;
            } else {
                String[] commands = c.split(" ");
                k += moveCommand.get(commands[0]) * Integer.parseInt(commands[1]);
            }
        }

        sb.append("O".repeat(size));
        while (!indexUndo.isEmpty()) {
            Integer index = indexUndo.pop();
            sb.insert(index, "X");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};

        // "OOOOXOOO"
        System.out.println(solution(n, k, cmd));


        String[] cmd2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};
        // "OOXOXOOO"
        System.out.println(solution(n, k, cmd2));
    }
}
