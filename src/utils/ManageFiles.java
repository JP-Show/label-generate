package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManageFiles {
	private FileReader file;
	
	public ManageFiles(FileReader file) {
		this.file = file;
	}
	
	public List<String> fileToString() throws IOException {
		BufferedReader br = new BufferedReader(this.file);
		List<String> text = new ArrayList<>();
		
		String line = br.readLine();
		while(line != null) {
			text.add(line);
			line = br.readLine();
		}
		
		return text;
	}
}
