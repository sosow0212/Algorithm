package com.sosow0212.프로그래머스;


public class 로또의최고순위와최저순위 {
    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCount = 0;
        int matchCount = 0;

        for(int l : lottos) {
            if(l == 0)
                zeroCount ++;
            else {
                for(int w : win_nums) {
                    if(l == w) {
                        matchCount ++;
                    }
                }
            }
        }

        int max = matchCount + zeroCount;
        int low = matchCount;

        int[] answer = {Math.min(7 - max, 6), Math.min(7 - low, 6)};
        return answer;

    }


    public static void main(String[] args) {
        로또의최고순위와최저순위 sol = new 로또의최고순위와최저순위();
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_numbs = {31, 10, 45, 1, 6, 19};
        int[] answer = sol.solution(lottos, win_numbs);
        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
