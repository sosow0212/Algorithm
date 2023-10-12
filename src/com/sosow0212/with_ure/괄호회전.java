package com.sosow0212.with_ure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class 괄호회전 {

    static Map<Character, Character> pair = Map.of(
            '(', ')',
            '{', '}',
            '[', ']'
    );

    public static int solution(String s) {
        int answer = 0;

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            deque.add(s.charAt(i));
        }

        if (isCorrect(new ArrayList<>(deque))) {
            answer++;
        }

        for (int i = 1; i < s.length(); i++) {
            deque.offerLast(deque.pollFirst());
            if(isCorrect(new ArrayList<>(deque))) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isCorrect(List<Character> list) {
        Stack<Character> stack = new Stack<>();

        for (Character c : list) {
            if (!stack.isEmpty() && Objects.equals(pair.get(stack.peek()), c)) {
                stack.pop();
                continue;
            }

            stack.push(c);
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3

        System.out.println(solution("}]()[{")); // 2

        System.out.println(solution("[)(]")); // 0
    }
}
