package utils;

import java.util.ArrayList;
import java.util.List;

public class Recorted {
	
	public static List<String> polish (List<String> list, String begin, String end) {
		return list.subList(list.indexOf(begin),list.indexOf(end));
	}
	
	public static List<String> pickup (String[] items, List<String> report){
		List<String> newReport = new ArrayList<>();
		report.forEach(line -> {
			for(String item : items) {
				if(line.contains(item)) {
					newReport.add(line);
					break;
				}
			}
		});
		return newReport;
	}
}
