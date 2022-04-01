package com.sosow0212.프로그래머스;

import java.util.HashSet;

class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        /** Set을 이용해서 풀 수 있는 문제.
         *  Set은 중복 허용 x
         *  lost = 잃어버린 학생의 배열, reserve = 빌려줄 수 있는 여분 옷이 있는 학생의 배열
         *  전체 n에서 lostSet의 인원을 빼면 정답이 된다.
         */

        // 1. set을 만든다
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for(int i : reserve)
            reserveSet.add(i);
        for(int i : lost) {
            lostSet.add(i);
            // 중복 확인
            if(reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }


        // 2. 여분을 기준으로 앞뒤로 확인하여 체육복을 빌려준다.
        for (int i : lost) {
            if(lostSet.contains(i-1)) {
                lostSet.remove(i-1);
            } else if(lostSet.contains(i+1)) {
                lostSet.remove(i+1);
            }
        }

        // 3. 전체 학생 수에서 lostSet에 남은 학생 수를 빼주면 정답이다.

        return n - lostSet.size();
    }

    public static void main(String[] args) {
        체육복 sol = new 체육복();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(n, lost, reserve));
    }
}
