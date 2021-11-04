package study;

import java.util.*;

public class q9086 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String str = "";
		
		for(int i=0; i<t; i++) {
			str = sc.next();
			System.out.println(str.charAt(0) + "" + str.charAt(str.length()-1));
		}
	}
}
