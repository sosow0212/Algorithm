import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class q1598 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int x1, x2, y1, y2;    
        
        if (num1 % 4 == 0) { 
            x1 = 3;
            y1 = num1 / 4 - 1;
        }else {             
            x1 = num1 % 4 - 1;
            y1 = num1 / 4;
        }
        
        if (num2 % 4 == 0) {
            x2 = 3;
            y2 = num2 / 4 - 1;
        }else {
            x2 = num2 % 4 - 1;
            y2 = num2 / 4;
        }
 
        int result = 0;
        if(x1 > x2) {    
            result += x1 - x2;
        }else {
            result += x2 - x1;
        }
        
        if(y1 > y2) {
            result += y1 - y2;
        }else {
            result += y2 - y1;
        }
        System.out.println(result);
        
 
    }
 
}
