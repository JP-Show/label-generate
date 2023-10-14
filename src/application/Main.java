package application;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Label;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;


import entities.Report;
import model.exceptions.FormatException;
import utils.ManageFiles;
import utils.Recorted;

public class Main {

	public static void main(String[] args) {
		String beggin = "--------[ Sumário ]-----------------------------------------------------------------------------------------------------";
		String end = "    Fabricante do processador:";
		
		try {
			
			OdfTextDocument odt = (OdfTextDocument) OdfDocument.loadDocument("C:\\Users\\Usuário\\Desktop\\etiqueta\\Pad.odt");
			
			List<String> textFile = new ArrayList<>();
			FileReader fr = new FileReader("C:\\Users\\Usuário\\Desktop\\etiqueta\\e3.txt");
			ManageFiles mf = new ManageFiles(fr);
			textFile = mf.fileToString();
			
			
			String[] arr = new String[] { "Tipo de processador", "Nome da Placa Mãe", "Atualizar", "Disco rígido",
					"Sistema operacional", "DIMM", "Tipo de Computador", };
			List<String> testArr = Recorted.polish(textFile,beggin, end);
			Report report = new Report(testArr, arr);

			//for(String line : report.getReport())
			//	System.out.println(line);
			
			Label label = new Label(report.getReport());
			System.out.println(label.toString());
			

			odt.getTableList().get(0).getCellByPosition(0, 0).setDisplayText(label.toString());;

			
			odt.save("C:\\Users\\Usuário\\Desktop\\etiqueta\\test2.odt");
			
		}catch (IOException err) {
			System.out.println("error para pegar as informação" + err.getMessage());
		}catch (FormatException err) {
			System.out.println("error ao gerar o arquivo " + err.getMessage());
		} catch (Exception err) {
			System.out.println("error ao gerar o arquivo " + err.getMessage());
		}

	}

}
