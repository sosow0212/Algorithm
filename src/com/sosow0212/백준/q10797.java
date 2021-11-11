package study;

import java.util.Scanner;

public class q10797 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[5];
		int ans = 0;
		
		for(int i=0; i<5; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == n) {
				ans ++;
			}
		}
		
		System.out.println(ans);

	}

}
