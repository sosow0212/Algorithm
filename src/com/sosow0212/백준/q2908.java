package study;

import java.util.*;

public class q2908 {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		String input1 = in.next();

		String input2 = in.next();

		String temp = "";

		for (int i = input1.length() - 1; i >= 0; i--) {

			temp += input1.charAt(i);

		}

		String temp2 = "";

		for (int i = input2.length() - 1; i >= 0; i--) {

			temp2 += input2.charAt(i);

		}

		int result1 = Integer.parseInt(temp);

		int result2 = Integer.parseInt(temp2);

		if (result1 > result2)

			System.out.println(result1);

		else

			System.out.println(result2);

	}

}
