package study;

import java.util.Scanner;

public class q15727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n%5 == 0) {
			System.out.println(n/5);
		} else if(n%5 != 0) {
			System.out.println(n/5 + 1);
		}

	}

}
