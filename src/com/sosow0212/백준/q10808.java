package study;

import java.util.*;

public class q10808 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// 97 a / 122 Z
		int[] alp = new int[25];
		int[] alpCount = new int[25];
		
		
		for(int i=0; i<25; i++) {
			alp[i] = 97+i;
			alpCount[i] = 0;
		}
		
		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<25; j++) {
				if(str.charAt(i) == alp[j]) {
					alpCount[j] ++;
				}
			}
		}
		
		for(int i=0; i<25; i++) {
			System.out.print(alpCount[i] + " ");
		}
	}

}
