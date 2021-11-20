package study;

import java.util.*;

public class q5554 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		int sum = 0;
		for(int i=0; i<4; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int min = sum/60;
		int sec = sum - (min*60);
		System.out.println(min);
		System.out.println(sec);
	}

}
