package entities;

import java.util.ArrayList;
import java.util.List;

import utils.Recorted;

public class Disks {
	List<Disk> listDisk = new ArrayList<>();
	List<String> reportDisk = new ArrayList<>();
	List<String> reportType = new ArrayList<>();
	public Disks(List<String> report) {
		this.reportDisk = Recorted.pickup(new String[] {"Capacidade depois de formatado"}, report);
		this.reportType = Recorted.pickup(new String[] {"Velocidade de rotação"}, report);

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
		String qt = "";
		int num = 0;
		for(String disk : this.reportDisk) {
			if(disk.isEmpty() == false) {
				qt = disk.substring(50).replaceAll(" ", "");
				if(this.reportType.get(num).contains("RPM")) 
					ssdOrHdd = "HDD";
				else
					ssdOrHdd = this.reportType.get(num).substring(50);
			}else {
				qt = "unknown";
				ssdOrHdd = "unknown";
			}
			Disk newDisk = new Disk(qt, ssdOrHdd);
			this.listDisk.add(newDisk);
			num++;
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
