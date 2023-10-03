package application;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Report;
import utils.ManageFiles;
import utils.Recorted;

public class Main {

	public static void main(String[] args) {
		String beggin = "--------[ Sum�rio ]-----------------------------------------------------------------------------------------------------";
		String end = "    Fabricante do processador:";
		
		try {
			List<String> textFile = new ArrayList<>();
			FileReader fr = new FileReader("C:\\Users\\Usu�rio\\Desktop\\etiqueta\\eti05.txt");
			ManageFiles mf = new ManageFiles(fr);
			textFile = mf.fileToString();

			String[] arr = new String[] { "Tipo de processador", "Nome da Placa M�e", "Atualizar", "Disco r�gido",
					"Nome do Sistema Operacional", "DIMM", "Tipo de n�cleo do Sistema Operacional", };
			List<String> testArr = Recorted.polish(textFile,beggin, end);
			Report report = new Report(testArr, arr);


			for (String line : report.getReport()) {
				System.out.println(line);
			}

		} catch (IOException err) {
			System.out.println(err.getMessage());
		}

	}

}
