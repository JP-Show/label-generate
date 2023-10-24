package entities;

import java.util.List;

import utils.Recorted;

public class CPU {
	String reportCpu;
	String cpu;
	double ghz;

	public CPU(List<String> report) {
		this.reportCpu = Recorted.pickup(new String[] { "Tipo de processador" }, report).get(0);
		this.setInf();
	}

	public void setInf() {
		
		if (this.reportCpu.contains("Intel")) {
			this.cpu = this.reportCpu.substring(this.reportCpu.indexOf("Intel"), this.reportCpu.indexOf(","));
			String num = this.reportCpu.substring(this.reportCpu.indexOf(",") + 1, this.reportCpu.indexOf("MHz"));
			this.ghz = Double.parseDouble(num) / 1000;
		}else if (this.reportCpu.contains("AMD")) {
			this.cpu = this.reportCpu.substring(this.reportCpu.indexOf("AMD"), this.reportCpu.indexOf(","));
			String num = this.reportCpu.substring(this.reportCpu.indexOf(",") + 1, this.reportCpu.indexOf("MHz"));
			this.ghz = Double.parseDouble(num) / 1000;
		}else {
			this.ghz = 0;
			this.cpu = "unknown";
			return;
		}
	}

	@Override
	public String toString() {
		return this.cpu + ", " + this.ghz + "GHz";
	}

}
