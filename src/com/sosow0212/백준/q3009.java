package com.sosow0212.백준;

import java.io.IOException;
import java.util.Scanner;

class q3009{
    public static void main(String args[]) throws IOException{
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[3][2];
        int i,j,tempx,tempy;
        for(i=0; i<3;i++) {
            for(j=0; j<2;j++) {
                arr[i][j]=sc.nextInt();
            }
        } //여기까지 입력==========

        if(arr[0][0] == arr[1][0]) {
            tempx = arr[2][0];
        }else {
            if(arr[0][0] == arr[2][0]) {
                tempx = arr[1][0];
            }
            else
                tempx = arr[0][0];
        }

        if(arr[0][1] == arr[1][1]) {
            tempy = arr[2][1];
        }else {
            if(arr[0][1] == arr[2][1]) {
                tempy = arr[1][1];
            }
            else
                tempy = arr[0][1];
        }
        System.out.println(tempx+" "+tempy);
    }
}
