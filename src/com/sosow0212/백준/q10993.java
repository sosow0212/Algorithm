package study;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;

public class q10993 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		ArrayList<String> al = new ArrayList<>();
		
		if(n == 1) {
			System.out.println("*");
		}else if(n == 2) {
			System.out.println("*****");
			System.out.println(" ***");
			System.out.println("  *");
		}else if(n >= 3) {
			al.add("*****");
			al.add("***");
			al.add("*");
			for(int i = 3; i <= n; i++) {
				if(i%2 == 0) { 
					al.add(al.size()-1, "*"+al.remove(al.size()-1)+"*");
					int index = al.size()-1; 

					int count = al.get(al.size()-1).length()-4;
					String empty = "";
					for(; count >= 1;) {
						empty = "";
						for(int j = 0; j < count; j++) {
							empty += " ";
						}
						count-=2;
						al.add("*"+empty+"*");
				   
					}
					al.add("*");

					count = (al.get(index).length()- al.get(index-1).length())/2;
					empty = "";
					for(int k = index-1; k >= 0; k--) {
						empty = "";
						for(int j = 0; j < count; j++) {
							empty += " ";
						}
						al.add(k, "*"+empty+al.remove(k)+empty+"*");
						count += 2;
					}
				
					count = al.get(0).length() + 2;
					String star = "";
					for(int j = 0; j < count; j++) {
						star += "*";
					}
					al.add(0, star);
			
				}else {
					al.add(0,"*"+al.remove(0)+"*");
					
					int count = (al.get(0).length()- al.get(1).length())/2;
					String empty = "";
					for(int k = 1; k < al.size(); k++) {
						empty = "";
						for(int j = 0; j < count; j++) {
							empty += " ";
						}
						al.add(k, "*"+empty+al.remove(k)+empty+"*");
						count += 2;
				
					}
			
					count = al.get(al.size()-1).length() + 2;
					String star = "";
					for(int j = 0; j < count; j++) {
						star += "*";
					}
					al.add(star);
				 
					count = al.get(0).length()-4;
					for(;count >= 1;) {
						empty = "";
						for(int j = 0; j < count; j++) {
							empty += " ";
						}
						count -= 2;
						al.add(0, "*"+empty+"*");
					}
					al.add(0,"*");
				}   
		  
			}
			
			int count = 0;
			String empty ="";
			if(n%2 == 0) { 
				for(int j = 0; j < al.size(); j++) {
					empty = "";
					for(int k = 0; k < count; k++) {
						 empty += " ";
					 }
					 al.add(j, empty+al.remove(j));
					count++;
				}
			}else {
				count = 0;
				for(int j = al.size()-1; j >= 0; j--) {
					empty = "";
					for(int k = 0; k < count; k++) {		
						empty += " ";
					}
					al.add(j, empty+al.remove(j));
					count++;
              
				}
			
			}
			for(int i = 0; i < al.size(); i++) {
				System.out.println(al.get(i));
			}
			
		}
	}
}