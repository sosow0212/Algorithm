package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13458 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String student = br.readLine();
		StringTokenizer st = new StringTokenizer(student, " ");
		int room[] = new int[a];
		String bc = br.readLine();
		StringTokenizer st1 = new StringTokenizer(bc, " ");
		int b = Integer.parseInt(st1.nextToken());
		int c = Integer.parseInt(st1.nextToken());
		long num = 0;
		for (int i = 0; i < a; i++) {
			room[i] = Integer.parseInt(st.nextToken());
			room[i] -= b;
			num++;
// room이 음수일때도 결국 빠지게 되는데?
			if (room[i] >= 0) {
				if (room[i] / c == 0 && room[i] % c > 0) {
					num += (room[i] / c) + 1;
				}
				if (room[i] / c != 0 && room[i] % c > 0) {
					num += (room[i] / c) + 1;
				}
				if (room[i] / c != 0 && room[i] % c == 0) {
					num += (room[i] / c);
				}
			}
		}
		System.out.println(num);
	}
}
