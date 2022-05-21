package study;

import java.util.*;

public class q10156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int sum = n * k;
		int m = sc.nextInt();
		if (sum <= m) {
			System.out.println("0");
		} else {
			System.out.println(sum - m);
		}
	}
// 

}
