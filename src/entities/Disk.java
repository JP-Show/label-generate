package entities;

public class Disk {
	private String disk;
	private String type;
	
	public Disk () {
	}

	public Disk(String disk, String type) {
		this.disk = disk;
		this.type = type;
	}

	public String getDisk() {
		return disk;
	}

	public void setDisk(String disk) {
		this.disk = disk;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
