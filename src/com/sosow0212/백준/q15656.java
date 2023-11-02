package study;

import java.util.*;

public class q15656 {
	static int N, M;
	static int[] num;
	static int[] print;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		print = new int[M];
		for (int i = 0; i < N; i++)
			num[i] = sc.nextInt();
		Arrays.sort(num);
		bt(0);
		System.out.print(sb);
	}

	static void bt(int depth) {
		if (depth == M) {
			for (int i : print)
				sb.append(i + " ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			print[depth] = num[i];
			bt(depth + 1);
		}
	}
}
