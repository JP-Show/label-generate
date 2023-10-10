package entities;

import java.util.ArrayList;
import java.util.List;

import utils.Recorted;

public class Report {
	private List<String> report;

	public Report(List<String> report, String[] items) {
		this.report = report;
		this.report = Recorted.pickup(items, this.report);
		this.formatLine();
	}
	
	public List<String> getReport() {
		return report;
	}

	
	private void formatLine(){
		List<String> newReport = new ArrayList<>();
		this.report.forEach(line -> {
			newReport.add(line.trim());
			});
		this.report = newReport;
	}
}
