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
		String beggin = "--------[ Sumário ]-----------------------------------------------------------------------------------------------------";
		String end = "    Fabricante do processador:";
		
		try {
			List<String> textFile = new ArrayList<>();
			FileReader fr = new FileReader("C:\\Users\\Usuário\\Desktop\\etiqueta\\eti05.txt");
			ManageFiles mf = new ManageFiles(fr);
			textFile = mf.fileToString();

			String[] arr = new String[] { "Tipo de processador", "Nome da Placa Mãe", "Atualizar", "Disco rígido",
					"Nome do Sistema Operacional", "DIMM", "Tipo de núcleo do Sistema Operacional", };
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
