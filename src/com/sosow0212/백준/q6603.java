package study;
import java.util.*;

public class q6603 {
    static int N;
    static int[] group;
    static ArrayList<Integer> numbers;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            N = sc.nextInt();
            if (N == 0)
                break;
            group = new int[N];

            for (int i = 0; i < N; i++)
                group[i] = sc.nextInt();

            Arrays.sort(group);
            numbers = new ArrayList<>();

            combination(0, 0);
            System.out.println();

        }

    }

 

    static void combination(int depth, int idx) {

        // 번호는 6개
        if (depth == 6) {
            for (int i = 0; i < 6; i++) 
                System.out.print(numbers.get(i) + " ");

            System.out.println();
        }

        for (int i = idx; i < group.length; i++) {
            numbers.add(group[i]);
            combination(depth + 1, i + 1);
            numbers.remove(numbers.size() - 1);
        }
    }
}
