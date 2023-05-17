package com.sosow0212.프로그래머스;

class 예상대진표 {

    public int solution(int n, int a, int b) {
        int answer = 0;

        while (true) {
            if (a == b)
                break;
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        예상대진표 sol = new 예상대진표();

        // 3
        System.out.println(sol.solution(8, 4, 7));
    }
}
