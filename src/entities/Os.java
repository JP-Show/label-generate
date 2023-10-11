package entities;

import java.util.ArrayList;
import java.util.List;

import utils.Recorted;

public class Os {
	String typeOS = "unknown";
	String nameOS;
	List<String> reportOS = new ArrayList<>();

	public Os(List<String> report) {
		this.reportOS = Recorted.pickup(new String[] { "Tipo de Computador", "Sistema operacional" }, report);
		this.setInf();
	}

	public void setInf() {
		for (String line : this.reportOS) {
			if(line.contains("base x")) {
				this.typeOS = line.substring(line.indexOf("x"));
			}else {
				this.nameOS = line.substring(line.indexOf("Win"));
			}
		}
	}

	@Override
	public String toString() {
		return this.nameOS + " " + this.typeOS;
	}
	
}
