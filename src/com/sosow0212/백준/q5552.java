package study;

import java.util.*;

public class q5552 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int arr[] = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		System.out.println(sum);

	}

}
