package study;

import java.text.SimpleDateFormat;
import java.util.Date;

public class q10699 {
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		System.out.println(format.format(d));
	}
}