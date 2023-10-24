package entities;

import java.util.ArrayList;
import java.util.List;

import utils.Recorted;

public class Memory {
	
	final private String[] ITEM = new String[] {"DIMM1:", "DIMM2:", "DIMM3:", "DIMM4:"};
	private List<Memorie> memories = new ArrayList<>();
	private String type;
	private List<String> reportMemories;
	
	public Memory(List<String> report) {
		this.reportMemories = Recorted.pickup(ITEM, report);
		this.reportMemories = this.reportMemories.subList(0, this.reportMemories.size() / 2);
		this.setInfo();
	}
	
	public List<String> getReportMemories() {
		return reportMemories;
	}

	public void setReportMemories(List<String> reportMemories) {
		this.reportMemories = reportMemories;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private void setInfo () {
			
			List<Memorie> list = new ArrayList<>();
			if(this.reportMemories.size() == 0) {
				this.memories.add(new Memorie(1, "unknown"));
				this.type = "unknown";
				return;
			}
			for (String line : this.reportMemories) {
				if(list.size() == 0) {
					Memorie ram = new Memorie();
					ram.setMemory(line.substring(50, 55));
					ram.setHasTwin(1);
					list.add(ram);
				}else {
					int sizeList = list.size();
					for(int i = 0; i < sizeList; i++) {
						if( line.substring(50, 55).equals(list.get(i).getMemory())) {
							list.get(i).setHasTwin(list.get(i).getHasTwin() + 1);
						}else {
							Memorie ram = new Memorie();
							ram.setMemory(line.substring(50, 55));
							ram.setHasTwin(1);
							list.add(ram);
						}
					}
				}
			}
			
			this.memories = list;
			String m = this.reportMemories.get(0).toString();
			this.type = m.substring(m.indexOf("DDR"), m.indexOf("DDR") + 4).trim();
			
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.memories.size(); i++) {
			Memorie memorie = this.memories.get(i);
			if(i + 1 == this.memories.size() ) {
				sb.append(memorie.getHasTwin() / 2 + "x " + memorie.getMemory().replaceAll(" ", "") +" "+ this.type);
			}else {
				sb.append(memorie.getHasTwin() / 2 + "x " + memorie.getMemory().replaceAll(" ", "") + " | ");
			}
			
			
		}

		return sb.toString();
	}
	
}
