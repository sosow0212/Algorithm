package com.sosow0212.프로그래머스;

import java.util.HashSet;
import java.util.Iterator;

class 소수구하기 {
    HashSet<Integer> numberSet = new HashSet<>();

    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if (num == 0 || num == 1)
            return false;

        // 2. 에라토스테네스의 체의 limit을 계산한다.
        int lim = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 limit까지만 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void recursive(String comb, String others) {
        // comb = 지금까지 조합한 숫자
        // others = 아직 조합하지 않은 숫자

        // 1. 현재 조합을 set(중복제거)에 추가한다.
        if (!comb.equals("")) // 첫 comb는 빈 string이므로
            numberSet.add(Integer.valueOf(comb));

        // 2. 남은 숫자 중 한 개를 더해서 새로운 조합을 만든다.
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public int solution(String numbers) {
        int count = 0;

        // 1. 모든 조합의 숫자를 만든다. > recursive("", number)
        recursive("", numbers);
        System.out.println(numberSet);

        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();
        while (it.hasNext()) {
            int number = it.next();
            if (isPrime(number)) {
                count++;
            }
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }

    public static void main(String[] args) {
        소수구하기 sol = new 소수구하기();
        System.out.println(sol.solution("17"));

    }
}