package study;

import java.util.*;

public class q20492 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		double a = (n - (n *0.22));
		double b = n*0.8 + ((n*0.2) - ((n*0.2) * 0.22));
		System.out.println((int)a);
		System.out.println((int)b);
	}

}
