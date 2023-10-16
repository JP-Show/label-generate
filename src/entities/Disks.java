package entities;

import java.util.ArrayList;
import java.util.List;

import utils.Recorted;

public class Disks {
	List<Disk> listDisk = new ArrayList<>();
	List<String> reportDisk = new ArrayList<>();
	public Disks(List<String> report) {
		this.reportDisk = Recorted.pickup(new String[] {"Disco rígido"}, report);
		this.setInf();
		
	}
	public List<Disk> getListDisk() {
		return listDisk;
	}
	public void setListDisk(List<Disk> listDisk) {
		this.listDisk = listDisk;
	}
	public void setInf() {
		String ssdOrHdd = "";
		String name = "";
		for(String disk : this.reportDisk) {
			if(disk.contains("RPM")) {
				ssdOrHdd = "HDD";
			}else {
				ssdOrHdd = "SSD";
			}
			if(disk.contains("GB"))
				name = disk.substring(disk.indexOf("(") + 1, disk.indexOf("B") + 1).replaceAll(" ", "");
			Disk newDisk = new Disk(name, ssdOrHdd);
			this.listDisk.add(newDisk);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.listDisk.size(); i++) {
			Disk disk = this.listDisk.get(i);
			if(i + 1 == this.listDisk.size() ) {
				sb.append(disk.getType() +" "+ disk.getDisk());
			}else {
				sb.append( disk.getType() +" "+ disk.getDisk() + " | ");
			}
		}
		return sb.toString();

	}
	
	
}
