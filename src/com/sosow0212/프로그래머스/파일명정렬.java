package com.sosow0212.프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class 파일명정렬 {
    public static List<String> solution(String[] files) {
        List<String> answer = Arrays.stream(files)
                .map(File::new)
                .sorted()
                .map(File::getFileName)
                .collect(Collectors.toList());
        return answer;
    }

    private static class File implements Comparable<File> {
        private String fileName;
        private String head;
        private int number;

        public File(String fileName) {
            this.fileName = fileName;
            getHeader();
            getNumber();
        }

        private void getHeader() {
            this.head = fileName.replaceFirst("^([a-zA-z\\s\\.\\-]*).*", "$1");
        }

        private void getNumber() {
            this.number = Integer.parseInt(fileName.replaceFirst("^[a-zA-z\\s\\.\\-]*([0-9]*).*", "$1"));
        }

        @Override
        public int compareTo(File o) {
            if (!this.head.equalsIgnoreCase(o.head)) {
                return this.head.toUpperCase(Locale.ROOT).compareTo(o.head.toUpperCase(Locale.ROOT));
            } else if (this.number != o.number) {
                return Integer.compare(this.number, o.number);
            } else {
                return 1;
            }
        }

        public String getFileName() {
            return fileName;
        }
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(solution(files));
        // 출력: ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
    }
}
