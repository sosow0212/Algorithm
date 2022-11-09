package com.sosow0212.프로그래머스;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 주차요금계산 {
    public static List<Integer> solution(int[] fees, String[] records) {
        HashMap<String, String> numberAndInTime = new HashMap<>(); // 차랑번호, In시간
        HashMap<String, Integer> timeOfParking = new HashMap<>(); // 누적 주차시간 (차량번호, 시간(분))
        HashMap<String, Integer> priceOfParking = new HashMap<>(); // 주차 비용 (차량번호, 비용)

        for (String record : records) {
            String[] recordArr = record.split(" ");
            if (recordArr[2].equals("IN")) {
                numberAndInTime.put(recordArr[1], recordArr[0]);
            } else if (recordArr[2].equals("OUT")) {
                String inTime = numberAndInTime.get(recordArr[1]);
                String outTime = recordArr[0];
                // 누적 주차시간 더함
                timeOfParking.put(recordArr[1],
                        timeOfParking.getOrDefault(recordArr[1], 0) + getRecordParkingTime(inTime, outTime));
                numberAndInTime.remove(recordArr[1]);
            }
        }

        // 출차를 안한 차량 계산
        for (String record : records) {
            String[] recordArr = record.split(" ");
            if (numberAndInTime.containsKey(recordArr[1])) {
                String inTime = numberAndInTime.get(recordArr[1]);
                timeOfParking.put(recordArr[1],
                        timeOfParking.getOrDefault(recordArr[1], 0) + getRecordParkingTime(inTime, "23:59"));
                numberAndInTime.remove(recordArr[1]);
            }
        }

        // 주차 요금 계산
        for (String key : timeOfParking.keySet()) {
            int parkingTime = timeOfParking.get(key); // 주차 시간
            priceOfParking.put(key, getPriceOfParking(parkingTime, fees));
        }


        // 정렬 후 값 리턴
        return priceOfParking.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    // in, out 시간으로 주차 시간을 구해주는 함수
    public static int getRecordParkingTime(String inTime, String outTime) {
        String[] outTimes = outTime.split(":");
        String[] inTimes = inTime.split(":");

        int outMin = Integer.parseInt(outTimes[0]) * 60 + Integer.parseInt(outTimes[1]);
        int inMin = Integer.parseInt(inTimes[0]) * 60 + Integer.parseInt(inTimes[1]);

        return (outMin - inMin);

    }

    // 주차 가격을 측정
    public static int getPriceOfParking(int parkingTime, int[] fees) {
        int price = 0;
        if (parkingTime <= fees[0]) {
            return fees[1];
        } else {
            parkingTime -= fees[0];
            price += fees[1];
            price += (Math.ceil(parkingTime / (fees[2] * 1.0)) * fees[3]);
        }
        return price;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600}; // 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(solution(fees, records)); // 14600, 34400, 5000
    }
}
