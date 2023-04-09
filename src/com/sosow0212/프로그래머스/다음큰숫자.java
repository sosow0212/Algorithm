package com.sosow0212.프로그래머스;

public class 다음큰숫자 {
    static public int solution(int n) {
        int answer;

        String binaryN = Integer.toBinaryString(n);
        int countOfN = countOfOne(binaryN);

        int num = n + 1;
        while (true) {
            if (countOfOne(Integer.toBinaryString(num)) == countOfN) {
                answer = num;
                break;
            }
            num++;
        }

        return answer;
    }

    static int countOfOne(String binaryNum) {
        int count = 0;
        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) - '0' == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(78)); // 83
    }
}
