package com.sosow0212.프로그래머스다시;

public class 체육복2 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n];
        for (int i : lost) {
            students[i - 1]--;
        }

        for (int i : reserve) {
            students[i - 1]++;
        }

        for (int i = 0; i < students.length; i++) {
            if (students[i] == -1) {
                if (i >= 1 && students[i - 1] == 1) {
                    students[i - 1]--;
                    students[i]++;
                } else if (i < n - 1 && students[i + 1] == 1) {
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }

        for (int student : students) {
            if (student >= 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // 5
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }
}
