package study;

import java.util.*;

public class q2776 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			int[] arr1 = new int[n];
			for(int f=0; f<n; f++) {
				arr1[f] = sc.nextInt();
			}
			
			int m = sc.nextInt();
			int[] arr2 = new int[m];
			for(int f=0; f<n; f++) {
				arr2[f] = sc.nextInt();
			}
			
			for(int j=0; j<m; j++) {
				int count = 0;
				for(int k=0; k<n; k++) {
					if(arr2[j] == arr1[k]) {
						count ++;
						if(count >= 1) count = 1;
					}
				}
				System.out.print(count + " ");
			}
		}
	}

}
