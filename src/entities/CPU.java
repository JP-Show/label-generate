package entities;

import java.util.List;

import utils.Recorted;

public class CPU {
	String reportCpu;
	String cpu;
	double ghz;
	
	public CPU (List<String> report) {
		this.reportCpu = Recorted.pickup(new String[] { "Tipo de processador" }, report).get(0);
		this.setInf();
	}
	
	public void setInf() {
		this.cpu = this.reportCpu.substring(this.reportCpu.indexOf("Intel"), this.reportCpu.indexOf(","));
		String num = this.reportCpu.substring(this.reportCpu.indexOf(",") + 1, this.reportCpu.indexOf("MHz"));
		this.ghz = Double.parseDouble(num) / 1000;
	}

	@Override
	public String toString() {
		return this.cpu + " " + this.ghz + "GHz";
	}
	
}
