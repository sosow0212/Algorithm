package com.sosow0212.프로그래머스;

import java.util.ArrayList;

public class 줄서는방법 {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        long factorial = 1;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            factorial *= i;
            list.add(i);
        }

        k--;

        while (n > 0) {
            factorial /= n;
            int temp = (int) (k / factorial);
            answer[index] = list.get(temp);
            list.remove(temp);

            k %= factorial;
            index++;
            n--;
        }
        return answer;
    }

    public static void main(String[] args) {
        줄서는방법 sol = new 줄서는방법();

        int[] a = sol.solution(3, 5);
        // 3, 1, 2
        for (int i : a) {
            System.out.println(i);
        }
    }
}
