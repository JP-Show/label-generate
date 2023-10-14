package entities;

import java.util.List;

public class Label {
	Os os;
	Motherboard motherboard;
	CPU cpu;
	Memory ram;
	Disks disk;
	
	public Label(List<String> report) {
		this.os = new Os(report);
		this.motherboard = new Motherboard(report);
		this.cpu = new CPU(report);
		this.ram = new Memory(report);
		this.disk = new Disks(report);
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("SISTEMA = " + this.os.toString().toUpperCase().trim());
		sb.append("\nPLACA MÃE = " + this.motherboard.toString().toUpperCase().trim());
		sb.append("\nPROCESSADOR = " + this.cpu.toString().toUpperCase().trim());
		sb.append("\nMEMÓRIA = " + this.ram.toString().toUpperCase().trim());
		sb.append("\nDISCO = "+this.disk.toString().toUpperCase().trim());
		return sb.toString();
	}
	
	
}
