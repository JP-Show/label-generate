package entities;

import java.util.List;

import model.exceptions.FormatException;
import utils.Recorted;

public class CPU {
	String reportCpu;
	String cpu;
	double ghz;

	public CPU(List<String> report) {
		this.reportCpu = Recorted.pickup(new String[] { "Tipo de processador" }, report).get(0);
		this.setInf();
	}

	public void setInf() throws FormatException {
		if (this.reportCpu.contains("Intel")) {
			this.cpu = this.reportCpu.substring(this.reportCpu.indexOf("Intel"), this.reportCpu.indexOf(","));
			String num = this.reportCpu.substring(this.reportCpu.indexOf(",") + 1, this.reportCpu.indexOf("MHz"));
			this.ghz = Double.parseDouble(num) / 1000;
		}else if (this.reportCpu.contains("AMD")) {
			this.cpu = this.reportCpu.substring(this.reportCpu.indexOf("AMD"), this.reportCpu.indexOf(","));
			String num = this.reportCpu.substring(this.reportCpu.indexOf(",") + 1, this.reportCpu.indexOf("MHz"));
			this.ghz = Double.parseDouble(num) / 1000;
		}else {
			throw new FormatException("error a setar a cpu");
		}
	}

	@Override
	public String toString() {
		return this.cpu + " " + this.ghz + "GHz";
	}

}
