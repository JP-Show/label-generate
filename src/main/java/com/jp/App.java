package com.jp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.odftoolkit.odfdom.doc.OdfDocument;
import org.odftoolkit.odfdom.doc.OdfTextDocument;

import com.exceptions.myException;
import com.hardware.Cpu;
import com.hardware.Disk;
import com.hardware.Memory;
import com.hardware.Motherboard;
import com.hardware.Os;
import com.hardware.Socket;
import com.label.MakeLabel;
import com.odf.Report;

public final class App {
    public static void main(String[] args) throws Exception {

        try (InputStream input = new FileInputStream("config.properties")) {
            DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");
            LocalDateTime date = LocalDateTime.now();

            Properties prop = new Properties();
            prop.load(input);

            String path = prop.getProperty("fileSaveLabel");

            String currentDir = System.getProperty("user.dir");
            System.out.println(currentDir);

            String cpu = Cpu.getName();
            String disk = Disk.getName();
            String ram = Memory.getName();
            String mb = Motherboard.getName();
            String os = Os.getName();
            String socket = Socket.getName();

            if (socket.contains("SOCKET")) {
                String dirFile = prop.getProperty("dirFile");
                String pathSK = "";
                pathSK = currentDir.replace(dirFile, "");

                File file = new File(pathSK);
                File[] files = file.listFiles();

                for (File line : files) {
                    if (line.toString().contains("txt")) {
                        FileReader fr = new FileReader(line);

                        String socket2 = Report.pickOne(fr, "-[ CPUID ]-", "-[ Placa mãe ]-",
                                "Identificador da plataforma");
                        socket = socket2;
                    }
                }

            }

            MakeLabel ml = new MakeLabel(os, cpu, mb, ram, disk, socket);

            OdfTextDocument otd = (OdfTextDocument) OdfDocument.loadDocument(path + "\\Model.odt");
            otd.getTableList().get(0).getCellByPosition(0, 0).setDisplayText(ml.getLabel());

            otd.save(path + "\\Relatorio" + date.format(ftd) + ".odt");

            System.out.println("Relatório feito com sucesso :3");

        } catch (myException | IOException e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
    }
}
