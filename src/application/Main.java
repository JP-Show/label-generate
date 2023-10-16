package application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

import entities.Label;
import entities.Report;
import utils.ManageFiles;
import utils.Recorted;

public class Main {

	public static void main(String[] args) throws Exception {
		String beggin = "--------[ Sumário ]-----------------------------------------------------------------------------------------------------";
		String end = "--------[ CPUID ]-------------------------------------------------------------------------------------------------------";
		// String end = " Fabricante do processador:";
		String path = "\\\\192.168.30.250\\programas\\Etiquetas";
		System.out.println(path);
		try {

			File file = new File(path);
			File[] files = file.listFiles();
			OdfTextDocument odt = (OdfTextDocument) OdfDocument.loadDocument(path + "\\Pad.odt");

			int i = 0;

			for (File line : files) {

				if (line.toString().contains("txt")) {

					List<String> textFile = new ArrayList<>();

					FileReader fr = new FileReader(line);

					ManageFiles mf = new ManageFiles(fr);
					textFile = mf.fileToString();

					String[] arr = new String[] { "Tipo de processador", "Nome da Placa Mãe",
							"Identificador da plataforma", "Disco rígido", "Sistema operacional", "DIMM",
							"Tipo de Computador", };
					List<String> testArr = Recorted.polish(textFile, beggin, end);
					Report report = new Report(testArr, arr);
					
					//for (String a : report.getReport())
					//	System.out.println(a);
					
					Label label = new Label(report.getReport());
					
					System.out.println(label.toString());
					System.out.println();

					odt.getTableList().get(0).getCellByPosition(0, i).setDisplayText(label.toString());
					;

					i++;
				}

			}
			odt.save(path + "\\test2.odt");

		} catch (IOException err) {
			System.out.println("error para pegar as informação" + err.getMessage());
		}

	}

}
