package com.jp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

import com.hardware.Cpu;
import com.hardware.Disk;
import com.hardware.Memory;
import com.hardware.Motherboard;
import com.hardware.Os;
import com.hardware.Socket;
import com.label.MakeLabel;
import com.utils.Log;

public final class App {
    public static void main(String[] args) throws Exception {

        try (InputStream input = new FileInputStream("config.properties")) {
            DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");
            LocalDateTime date = LocalDateTime.now();

            Properties prop = new Properties();
            prop.load(input);

            String dirFile = prop.getProperty("dirFile");
            String pathSK = "";
            String currentDir = System.getProperty("user.dir");
            pathSK = currentDir.replace(dirFile, "");

            String path = prop.getProperty("fileSaveLabel");

            String cpu = Cpu.getName();
            String disk = Disk.getName();
            String ram = Memory.getName();
            String mb = Motherboard.getName();
            String os = Os.getName();
            String socket = Socket.getName(pathSK);

            MakeLabel ml = new MakeLabel(os, cpu, mb, ram, disk, socket);

            OdfTextDocument otd = (OdfTextDocument) OdfDocument.loadDocument(path + "\\Model.odt");
            otd.getTableList().get(0).getCellByPosition(0, 0).setDisplayText(ml.getLabel());

            otd.save(path + "\\Relatorio" + date.format(ftd) + ".odt");

            System.out.println("Relatório feito com sucesso :3");

        } catch (Exception e) {
            Log.createLogFile("Error no programa principal  " + e.getMessage());
            System.out.println("Error no programa principal  ");
        }
    }
}
