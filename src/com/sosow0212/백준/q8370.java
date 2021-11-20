package study;

import java.util.*;

public class q8370 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
        for(int i=0; i<4; i++) {
            arr[i] = sc.nextInt();
        }
		int sum = arr[0]*arr[1] + arr[2]*arr[3];
		System.out.println(sum);
	}

}