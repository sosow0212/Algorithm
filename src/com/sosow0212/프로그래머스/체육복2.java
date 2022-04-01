package com.sosow0212.프로그래머스;


class 체육복2 {
    public int solution(int n, int[] lost, int[] reserve) {
        /** List를 이용해서 푸는 그리디 문제
         *  student[n+2] 배열을 만들고, 여분이 있으면 1을 index에 저장하고
         *  여분이 없으면 0, 도난 당했으면 -1 을 저장한다.
         *  배열을 돌면서, 여분을 체크하면서 1을 증가 혹은 감소 시키면서 답을 구하면 된다.
         *  [n+2] 로 두는 이유는 1~5번 학생이면, 0과 6 인덱스를 추가로 증가시키면, 0,6은 신경쓰지 않을 수 있어서 코드가 깔끔해진다.
         */


        // 1. student 배열 생성
        int[] student = new int[n + 2];
        int answer = 0;


        // 2. reserve / lost 정보 입력
        for (int l : lost)
            student[l]--;
        for (int r : reserve)
            student[r]++;


        // 3. 여분을 기준으로 앞 뒤를 확인하면서 체육복을 빌려준다
        for (int i = 1; i <= n; i++) {
            if (student[i] == 1) {
                if (student[i - 1] == -1) {
                    student[i]--;
                    student[i - 1]++;
                } else if (student[i + 1] == -1) {
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }


        // 4. 체육복을 가진 학생 수를 계산한다.
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 0)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        체육복2 sol = new 체육복2();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(n, lost, reserve));
    }
}
