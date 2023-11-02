package study;

import java.util.*;
public class q10101 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a2 = sc.nextInt();
		int a3 = sc.nextInt();
		
		if(a1 == 60 && a2 == 60 && a3 == 60)
			System.out.println("Equilateral");
		else if(a1 + a2 + a3 == 180 && ((a1 == a2)||(a1 == a3) || (a2 == a3)))
			System.out.println("Isosceles");
		else if(a1 + a2 + a3 == 180 && ((a1 != a2)||(a1 != a3) || (a2 != a3)))
			System.out.println("Scalene");
		else
			System.out.println("Error");
		
	}
}