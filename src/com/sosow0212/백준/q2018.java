package study;

import java.util.*;
import java.io.*;

public class q2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		twoPoint(n);
		br.close();
	}

	private static void twoPoint(int n) {
		int left_idx = 0, right_idx = 0;
		int sum = 0, ans = 0;

		while (left_idx <= n) {
			while (++right_idx <= n) {
				sum += right_idx;

				if (sum >= n) {
					if (sum == n)
						ans++;
					break;
				}
			}

			while (++left_idx <= n) {
				sum -= left_idx;
				if (sum <= n) {
					if (sum == n)
						ans++;
					break;
				}
			}
		}

		System.out.println(ans);
	}
}