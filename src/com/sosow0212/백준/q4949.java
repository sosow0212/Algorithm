package com.sosow0212.백준;

import java.util.*;

public class q4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String a = sc.nextLine();
            if (a.equals(".")) break; // .은 종료
            String[] input = a.split(""); // 입력값들 쪼개서 넣기
            Stack<String> stack = new Stack<>();

            for (String str : input) {
                if (str.equals("(") || str.equals("[")) stack.push(str); // 열린 괄호는 그냥 넣기
                    // 닫히는 괄호는 스택이 비어있지 않고 바로 위 값이 열리는 짝 괄호면 pop
                else if (str.equals(")") && !stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else if (str.equals("]") && !stack.isEmpty() && stack.peek().equals("["))
                    stack.pop();
                    // 닫히는 괄호인데 해당 없으면 삽입
                else if (str.equals(")") || str.equals("]"))
                    stack.push(str);
            }

            if (stack.empty()) // 스택이 비었으면
                System.out.println("yes");
            else // 비지 않았으면
                System.out.println("no");
        }
    }
}