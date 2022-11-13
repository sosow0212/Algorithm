package com.sosow0212.프로그래머스;


class 짝수홀수개수 {
    public int[] solution(int[] num_list) {
        int[] answer = {0, 0};

        for (int n : num_list) {
            if (n % 2 == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }

        return answer;
    }
}