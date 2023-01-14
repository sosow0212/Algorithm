package com.sosow0212.프로그래머스;

import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int[] arr) {
        int[] answer;

        Queue<Integer> q = new LinkedList<>();

        q.add(arr[0]);
        int temp = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(temp == arr[i]) {
                continue;
            } else {
                q.add(arr[i]);
                temp = arr[i];
            }
        }
        answer = new int[q.size()];
        int i = 0;
        while(!q.isEmpty()) {
            answer[i] = q.poll();
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        같은숫자는싫어 sol = new 같은숫자는싫어();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(sol.solution(arr));
        // 1,3,0,1
    }
}
