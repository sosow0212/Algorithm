import java.io.*;
import java.util.*;
 
public class q3049 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int n = Integer.parseInt(br.readLine());
        int ans = (n *(n-1)*(n-2)*(n-3)) / (4*3*2);
        
        bw.write(String.valueOf(ans) + "\n");
        bw.flush();
        bw.close();
    }
}
