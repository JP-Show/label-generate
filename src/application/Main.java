package application;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Report;
import utils.ManageFiles;

public class Main {

	public static void main(String[] args) {
		try {
			List<String> textFile = new ArrayList<>();
			FileReader fr = new FileReader("C:\\Users\\Usuário\\Desktop\\etiqueta\\eti01.txt");
			ManageFiles mf = new ManageFiles(fr);
			textFile = mf.fileToString();
			Report report = new Report(textFile);
			String[] arr = new String[] {"Tipo de Computador" , "Sistema operacional"};
			
			for (String line : report.pickup(arr)) {
				System.out.println(line);
			}

		}catch(IOException err){
			System.out.println(err.getMessage());
		}
		
	}

}
