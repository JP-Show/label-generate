package entities;

import java.util.ArrayList;
import java.util.List;

import model.exceptions.FormatException;
import utils.Recorted;

public class Os {
	String typeOS = "";
	String nameOS = "";
	List<String> reportOS = new ArrayList<>();

	public Os(List<String> report) {
		this.reportOS = Recorted.pickup(new String[] { "Tipo de Computador", "Sistema operacional" }, report);
		this.setInf();
	}

	public void setInf() throws FormatException{
		if(this.reportOS.size() == 0) {
			this.typeOS = "Unknown";
			this.nameOS = "Unknown";
			throw new FormatException("report OS está vazio");
		}
		for (String line : this.reportOS) {
			if(this.typeOS.isEmpty() == false && this.nameOS.isEmpty() == false)
				return;
			
			if(line.contains(" x")) {
				this.typeOS = line.substring(line.indexOf("x"), line.indexOf("x") + 3);
			}else if(line.contains("Windows")) {
				this.nameOS = line.substring(line.indexOf("Windows"));
			}else {
				this.typeOS = "Unknown";
				this.nameOS = "Unknown";
			}
		}
	}

	@Override
	public String toString() {
		return this.nameOS + " " + this.typeOS;
	}
	
}
