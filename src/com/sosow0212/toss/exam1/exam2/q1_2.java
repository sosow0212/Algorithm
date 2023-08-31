package com.sosow0212.toss.exam1.exam2;

public class q1_2 {

    public int solution(String s, int N) {
        int answer = -1;

        for (int i = 0; i <= s.length() - N; i++) {
            String substring = s.substring(i, i + N);

            boolean check = true;
            for (int j = 1; j <= N; j++) {
                if (!substring.contains(String.valueOf(j))) {
                    check = false;
                    break;
                }
            }

            if (check) {
                answer = Math.max(answer, Integer.parseInt(substring));
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        q1_2 sol = new q1_2();
        String s = "1451232125";
        int n = 2;

        System.out.println(sol.solution(s, n));
    }
}
