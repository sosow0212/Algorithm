package com.sosow0212.프로그래머스;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 파일명정렬하기 {

    static class File implements Comparable<File> {

        String origin;
        String head;
        int number;
        String tail;

        private File(final String origin, final String head, final int number, final String tail) {
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public static File from(final String file) {
            StringBuilder header = new StringBuilder();
            StringBuilder numbers = new StringBuilder();
            StringBuilder tail = new StringBuilder();

            int index = 0;
            while (index < file.length()) {
                char c = file.charAt(index);

                if (Character.isDigit(c)) {
                    break;
                }

                header.append(c);
                index++;
            }

            while (index < file.length()) {
                char c = file.charAt(index);

                if (!Character.isDigit(c)) {
                    break;
                }

                numbers.append(c);
                index++;
            }

            while (index < file.length()) {
                tail.append(file.charAt(index));
                index++;
            }

            return new File(
                    file,
                    header.toString(),
                    Integer.parseInt(numbers.toString()),
                    tail.toString()
            );
        }

        public String getOrigin() {
            return origin;
        }

        @Override
        public int compareTo(File o) {
            if (!this.head.equalsIgnoreCase(o.head)) {
                return this.head.toUpperCase().compareTo(o.head.toUpperCase());
            } else if (this.number != o.number) {
                return Integer.compare(this.number, o.number);
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "File{" +
                    "origin='" + origin + '\'' +
                    ", head='" + head + '\'' +
                    ", number=" + number +
                    ", tail='" + tail + '\'' +
                    '}';
        }
    }

    public static List<String> solution(String[] files) {
        return Arrays.stream(files)
                .map(File::from)
                .sorted()
                .map(File::getOrigin)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        // ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
        System.out.println(solution(files));


//        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
//         ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
//        System.out.println(Arrays.toString(solution(files2)));
    }
}
