package entities;

import java.util.ArrayList;
import java.util.List;

public class Report {
	List<String> report;

	public Report(List<String> report) {
		this.report = report;
	}
	
	public List<String> pickup(String[] items){
		List<String> newReport = new ArrayList<>();
		
		this.report.forEach(line -> {
			for(String item : items) {
				if(line.contains(item))
					newReport.add(line);
				break;
			}
		});
		return newReport;
	}
	
}
