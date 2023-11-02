package study;

import java.util.Scanner;

public class q2902 {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();
        
        String[] strArray = input.split("-");
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i < strArray.length; i++) {
            sb.append(strArray[i].charAt(0));
        }
 
        System.out.println(sb);
        scan.close();
    }
}


