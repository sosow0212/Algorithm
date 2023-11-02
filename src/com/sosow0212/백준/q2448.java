package study;

import java.io.*;

public class q2448 {
    static BufferedReader br = null;
    static BufferedWriter bw = null;
    static StringBuilder sb = null;
    static String[] arr = null;
    static int n;

    public static void divideAndConquer(int k) {
        int end = 3 * (int)Math.pow(2, k);  // k�� Ŀ�� ������ ������ �ι辿 �þ��
        int mid = end / 2;

        for(int i = mid; i < end; i++) {  // �Ʒ��� ���� ������ ���� ���� ������ ������ ���̿� �ΰ� �� �� �̾���� ���̴�
            arr[i] = arr[i - mid] + " " + arr[i - mid];
        }

        sb.delete(0, sb.length());
        while(sb.length() < mid) {
            sb.append(" ");
        }

        for(int i = 0; i < mid; i++) {  // ���� ���� ������ �翷�� ��ü ���� ���� ���ݸ�ŭ ������ �߰��ȴ�
            arr[i] = sb.toString() + arr[i] + sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new String[n];

        arr[0] = "  *  ";
        arr[1] = " * * ";
        arr[2] = "*****";

        for(int k = 1; 3 * (int)Math.pow(2, k) <= n; k++) {
            divideAndConquer(k);
        }

        sb.delete(0, sb.length());
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}