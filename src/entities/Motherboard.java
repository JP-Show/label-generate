package entities;

import java.util.List;

import model.exceptions.FormatException;
import utils.Recorted;

public class Motherboard {
	String motherboard;
	String socket;
	
	public Motherboard (List<String> report) {
		this.motherboard = Recorted.pickup(new String[] { "Nome da Placa Mãe" }, report).get(0);
		this.socket = Recorted.pickup(new String[] {"Atualiza" }, report).get(0) ;
		this.setInf();
	}
	
	public void setInf ( ) throws FormatException {
		if(this.motherboard.contains("("))
			this.motherboard = this.motherboard.substring(50, this.motherboard.indexOf("("));
		else
			this.motherboard = this.motherboard.substring(50);
		
		if(this.socket != "") {
			this.socket = this.socket.substring(50).toUpperCase();
		}
		else {
			this.socket = "Unknown";			
		}
	}
	
	@Override
	public String toString() {
		return this.motherboard.trim() + " " + this.socket;
	}
	
}
