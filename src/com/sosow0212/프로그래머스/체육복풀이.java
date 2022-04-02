package com.sosow0212.프로그래머스;


import java.util.HashSet;

class 체육복풀이 {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();

        for(int i : reserve) {
            reserveSet.add(i);
        }

        for(int i : lost) {
            if(reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }


        for(int i : reserveSet) {
            if(lostSet.contains(i-1)) {
                lostSet.remove(i-1);
            } else if(lostSet.contains(i+1)) {
                lostSet.remove(i+1);
            }
        }

        return n - lostSet.size();
    }

    public static void main(String[] args) {
        체육복풀이 sol = new 체육복풀이();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(n, lost, reserve));
    }

}