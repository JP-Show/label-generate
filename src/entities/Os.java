package entities;

import java.util.ArrayList;
import java.util.List;

import model.exceptions.FormatException;
import utils.Recorted;

public class Os {
	String typeOS = "unknown";
	String nameOS;
	List<String> reportOS = new ArrayList<>();

	public Os(List<String> report) {
		this.reportOS = Recorted.pickup(new String[] { "Tipo de Computador", "Sistema operacional" }, report);
		this.setInf();
	}

	public void setInf() throws FormatException{
		if(this.reportOS.size() == 0) {
			throw new FormatException("report OS está vazio");
		}
		for (String line : this.reportOS) {
			if(line == "")
				throw new FormatException("linha da memória vazia");
			if(line.contains(" x")) {
				this.typeOS = line.substring(line.indexOf("x"));
			}else {
				this.nameOS = line.substring(line.indexOf("Windows"));
			}
		}
	}

	@Override
	public String toString() {
		return this.nameOS + " " + this.typeOS;
	}
	
}
