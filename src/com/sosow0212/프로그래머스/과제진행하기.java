package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class 과제진행하기 {

    static class Plan implements Comparable<Plan> {
        String sub;
        int startTime;
        int needTime;

        public Plan(String sub, int startTime, int needTime) {
            this.sub = sub;
            this.startTime = startTime;
            this.needTime = needTime;
        }

        public Plan(String sub, int needTime) {
            this.sub = sub;
            this.needTime = needTime;
        }

        @Override
        public int compareTo(final Plan o) {
            return this.startTime - o.startTime;
        }
    }

    public static String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();

        List<Plan> planList = new ArrayList<>();
        for (String[] plan : plans) {
            planList.add(new Plan(plan[0], getTime(plan[1]), Integer.parseInt(plan[2])));
        }
        Collections.sort(planList);

        Stack<Plan> waitList = new Stack<>();

        int nowTime = -1;

        for (int i = 0; i < planList.size(); i++) {
            if (waitList.isEmpty()) {
                waitList.push(planList.get(i));
                continue;
            }

            Plan nowPlan = waitList.peek();
            Plan newPlan = planList.get(i);

            nowTime = nowPlan.startTime;

            if (nowTime + nowPlan.needTime <= newPlan.startTime) {
                permutatioon(waitList, newPlan, nowTime, answer);
            } else {
                nowPlan.needTime -= newPlan.startTime - nowTime;
            }

            waitList.push(newPlan);
        }

        while (!waitList.isEmpty()) {
            answer.add(waitList.pop().sub);
        }

        return answer.toArray(new String[0]);
    }

    public static void permutatioon(Stack<Plan> waitList, Plan newPlan, int nowTime, List<String> answer) {
        if (waitList.isEmpty()) {
            return;
        }

        Plan curAss = waitList.peek();

        if (nowTime + curAss.needTime <= newPlan.startTime) {
            answer.add(waitList.pop().sub);
            permutatioon(waitList, newPlan, nowTime + curAss.needTime, answer);
            return;
        }

        curAss.needTime -= newPlan.startTime - nowTime;
    }

    static int getTime(String startTime) {
        String[] split = startTime.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};

        // ["science", "history", "computer", "music"]
        System.out.println(Arrays.toString(solution(plans)));
    }
}
