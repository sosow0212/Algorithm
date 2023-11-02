package study;

import java.util.*;

public class q1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		boolean arr[] = new boolean[n+1];
		
		arr[0] = true;
		arr[1] = true;
		
		for(int i=2; i<=Math.sqrt(n+1); i++) {
			for(int j=i*i; j<n+1; j+=i) {
				arr[j] = true;
			}
		}
		
		for(int i=m; i<n+1; i++) {
			if(arr[i] == false) 
				System.out.println(i);
		}

	}

}
