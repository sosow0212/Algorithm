import java.util.ArrayList;
import java.util.List;

public class 기사단원의무기 {
    static public int solution(int number, int limit, int power) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            list.add(getPrime(i));
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > limit) {
                answer += power;
                continue;
            }
            answer += list.get(i);
        }

        return answer;
    }

    public static int getPrime(int n) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i)
                    count++;
                else
                    count += +2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;
        System.out.println(solution(number, limit, power)); // 21

    }
}
