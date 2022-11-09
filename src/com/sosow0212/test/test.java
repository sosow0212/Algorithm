package com.sosow0212.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class test {
    public static void main(String[] args) {
        System.out.println(getPriceOfParking(334, new int[]{180, 5000, 10, 600}));
    }

    public static int getPriceOfParking(int parkingTime, int[] fees) {
        int price = 0;
        if (parkingTime <= fees[0]) {
            return fees[1];
        } else {
            price += fees[1];
            System.out.println("price " + price);
            System.out.println(parkingTime -= fees[0]
            );
            parkingTime -= fees[0];
            price += ((parkingTime / fees[2]) * fees[3]);
        }
        return price;
    }
}
