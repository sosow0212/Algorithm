package study;

import java.util.*;

public class q17413 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<Character>();
		int check = 0; // �±׾����� �ƴ��� üũ.
		String input = sc.nextLine();
		StringBuilder result = new StringBuilder();
		
		for(char ch : input.toCharArray()) {
			if(ch == '<') {
				check+=1; // �±� ���� �ǹ�.
				// �±� �������� ���� ������.
				while(!stack.isEmpty()) {
					result.append(stack.pop());
				}
				result.append("<");
			} else if(ch == '>') {
				check-=1; // �±� Ż��.
				result.append(">");
			} else if(ch == ' ') {
				// ���� �������� ���� ������.
				while(!stack.isEmpty())
					result.append(stack.pop());
				result.append(" ");
			} else {
				if(check == 0) // �±� ��
					stack.push(ch);
				else // �±� ��.
					result.append(ch);
			}
		}
		
		// ���ÿ� ���� ���� ������.
		while(!stack.isEmpty())
			result.append(stack.pop());
		
		System.out.println(result);
		sc.close();
		return;
	}
}

