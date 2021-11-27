package study;

import java.util.*;

public class q1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int num = 1;
		int count = 0;
		
		int[] arr = new int[1000];
		for(int i=0; i<1000; i++) {
			arr[i] = num;
			count ++;
			if(num == count) {
				num ++;
				count = 0;
			}
		}
		
		int sum = 0;
		for(int i=a-1; i<=b-1; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum);
	}

}
