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
		sb.append("SISTEMA = " + this.os.toString().toUpperCase());
		sb.append("\nPLACA MÃE = " + this.motherboard.toString().toUpperCase());
		sb.append("\nPROCESSADOR = " + this.cpu.toString().toUpperCase());
		sb.append("\nMEMÓRIA = " + this.ram.toString().toUpperCase());
		sb.append("\nDISCO = "+this.disk.toString().toUpperCase());
		return sb.toString();
	}
	
	
}
