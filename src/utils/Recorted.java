package utils;

import java.util.List;

public class Recorted {
	public static List<String> polish (List<String> list, String begin, String end) {
		return list.subList(list.indexOf(begin),list.indexOf(end));
	}
}
