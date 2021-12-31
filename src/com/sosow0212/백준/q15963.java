package study;

import java.util.Scanner;

public class q15963 {

	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);
		long N = scann.nextLong();
		long M = scann.nextLong();
		if(N == M)
			System.out.println("1");
		else
			System.out.println("0");
	}

}