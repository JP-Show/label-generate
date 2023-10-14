package utils;

import java.util.ArrayList;
import java.util.List;

import model.exceptions.FormatException;

public class Recorted {

	public static List<String> polish(List<String> list, String begin, String end) {
		return list.subList(list.indexOf(begin), list.indexOf(end));
	}

	public static List<String> pickup(String[] items, List<String> report) throws FormatException {

		List<String> newReport = new ArrayList<>();
		report.forEach(line -> {
			for (String item : items) {
				if (line.contains(item)) {
					newReport.add(line);
					break;
				}
			}
		});
		if(newReport.size() == 0) {
			newReport.add("");
		}

		return newReport;
	}
}
