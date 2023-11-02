package study;

import java.util.*;

public class q2512 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		
		Arrays.sort(arr);
		
		// 110, 120, 140, 150
		
		// 130 -> 110, 120, 130, 130 = 490
		
		int low = 0;
		int high = arr[arr.length-1];
		int result = 0;
		int mid = 0;
		int ans = 0;
		
		while(low <= high) {
			mid = (low + high) / 2;
			result = 0;

			for(int i=0; i<n; i++) {
				if(mid > arr[i]) {
					result += arr[i];
				} else {
					result += mid;
				}
			}
			
			if(result > m) {
				high = mid - 1;
			}
			
			else if(result <= m) {
				ans = mid;
				low = mid + 1;
			}
		}
		
		System.out.println(ans);
	}

}

// 30 40 70 80 100 = 320 / 5 = mid = 64
// 30 40 64 64 64 = 202 // if mid = 100
// 30 40 70 80 100 = 320