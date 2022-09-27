package com.sosow0212.프로그래머스;

import java.util.*;

public class 프린터 {
    static public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<progresses.length; i++) {
            int day = 0;
            if((100 - progresses[i]) % speeds[i] == 0) {
                day = (100 - progresses[i]) / speeds[i];
            } else {
                day = (100 - progresses[i]) / speeds[i] + 1;
            }

            q.add(day);
        }

        int count = 1;
        int now = q.poll();

        while(!q.isEmpty()) {
            int next = q.poll();
            if(now >= next) {
                count ++;
            } else {
                answer.add(count);
                now = next;
                count = 1;
            }
        }
        answer.add(count);

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(solution(progresses, speeds));// {2,1}
    }
}
