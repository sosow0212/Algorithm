package study;

import java.util.*;

public class q2447 {

	static char arr[][]; // nũ�⸸ŭ 2���� �迭�� �����Ѵ�.

	public static void star(int a, int b, int n) { // ���ȣ���� �ݺ� �� �޼ҵ��̴�.
		int div = 0;
		if (n == 1) { // ��� ȣ���� ������ �κ�
			arr[a][b] = '*';
			return;
		}

		div = n / 3; // �Է¹��� n ���� ��� 3�� �����ش�.

		for (int i = 0; i < 3; i++) { // 3x3ũ���� ���� �����.
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				star(a + (div * i), b + (div * j), div); // �������� �Ű��ش�. 27�� ��� (0,0) (0,9) ������ �Űܰ���.
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		arr = new char[n][n];

		for (int i = 0; i < arr.length; i++) {
			Arrays.fill(arr[i], ' ');
		}

		star(0, 0, n);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}