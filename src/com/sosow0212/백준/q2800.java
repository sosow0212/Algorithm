package com.sosow0212.백준;

import java.io.*;
import java.util.*;

public class q2800 {
    private static String str;
    private static List<String> list;
    private static Set<String> set;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        str = st.nextToken();
        list = new ArrayList<>();
        arr = new int[str.length()];
        set = new HashSet<>();
        int index = 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                arr[i] = index++;
            } else if (str.charAt(i) == ')') {
                arr[i] = --index;
            }
        }
        dfs(0, new Stack<>(), new String());
        list.addAll(set);
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static void dfs(int dep, Stack<Integer> stack, String s) {
        if (dep == str.length()) {
            set.add(s);
            return;
        }
        if (str.charAt(dep) == '(') {
            stack.add(arr[dep]);
            dfs(dep + 1, stack, s + '(');
            stack.pop();
            dfs(dep + 1, stack, s);
        } else if (str.charAt(dep) == ')') {
            if (!stack.isEmpty() && stack.peek() == arr[dep]) {
                stack.pop();
                dfs(dep + 1, stack, s + ')');
                stack.add(arr[dep]);
            } else {
                dfs(dep + 1, stack, s);
            }
        } else {
            dfs(dep + 1, stack, s + str.charAt(dep));
        }
    }

    static int stoi(String s) {
        return Integer.valueOf(s);
    }
}
