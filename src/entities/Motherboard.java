package entities;

import java.util.List;

import utils.Recorted;

public class Motherboard {
	String motherboard;
	String socket;
	
	public Motherboard (List<String> report) {
		this.motherboard = Recorted.pickup(new String[] { "Nome da Placa Mãe" }, report).get(0);
		this.socket = Recorted.pickup(new String[] {"Atualizar" }, report).get(0);
		this.setInf();
	}
	public void setInf () {
		this.motherboard = this.motherboard.substring(50);
		this.socket = this.socket.substring(50).toUpperCase();
	}
	@Override
	public String toString() {
		return this.motherboard + " " + this.socket;
	}
	
}
