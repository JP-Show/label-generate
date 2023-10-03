package entities;

import java.util.ArrayList;
import java.util.List;

public class Report {
	private List<String> report;

	public Report(List<String> report, String[] items) {
		this.report = report;
		this.pickup(items);
		this.formatLine();
	}
	
	public List<String> getReport() {
		return report;
	}

	private void pickup(String[] items){
		List<String> newReport = new ArrayList<>();
		this.report.forEach(line -> {
			for(String item : items) {
				if(line.contains(item)) {
					newReport.add(line);
					break;
				}
			}
		});
		this.report = newReport;
	}
	
	private void formatLine(){
		List<String> newReport = new ArrayList<>();
		this.report.forEach(line -> {
			newReport.add(line.trim());
			});
		this.report = newReport;
	}
}
