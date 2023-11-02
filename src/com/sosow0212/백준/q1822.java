import java.util.*;
import java.io.*;

public class q1822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int NUMBER_OF_A = Integer.parseInt(st.nextToken());
        final int NUMBER_OF_B = Integer.parseInt(st.nextToken());

        ArrayList<Integer> listA = new ArrayList<Integer>();
        ArrayList<Integer> listB = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUMBER_OF_A; i++) {

            listA.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NUMBER_OF_B; i++) {
            listB.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(listA);
        Collections.sort(listB);

        int count = 0;
        ArrayList<Integer> answer = new ArrayList<Integer>();
        int pivot = 0;
        for (int i = 0; i < NUMBER_OF_A; i++) {
            if (pivot != NUMBER_OF_B) {
                if (listA.get(i) < listB.get(pivot)) {
                    answer.add(listA.get(i));
                    count++;
                } else if (listA.get(i) > listB.get(pivot)) {
                    pivot++;
                    i--;
                } else {
                    pivot++;
                }
            } else {
                answer.add(listA.get(i));
                count++;
            }
        }
        sb.append(count);
        sb.append("\n");
        for (Integer k : answer) {
            sb.append(k);
            sb.append(" ");
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }


}