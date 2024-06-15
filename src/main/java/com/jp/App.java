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
    private static Cpu cp = new Cpu();
    private static Disk dk = new Disk();
    private static Memory mm = new Memory();
    private static Motherboard mb2 = new Motherboard();
    private static Os o = new Os();
    private static Socket sk = new Socket();
    private static String pathSK = "";

    public static void main(String[] args) throws Exception {

        try (InputStream input = new FileInputStream("config.properties")) {
            DateTimeFormatter ftd = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm");
            LocalDateTime date = LocalDateTime.now();

            Properties prop = new Properties();
            prop.load(input);

            String dirFile = prop.getProperty("dirFile");

            String currentDir = System.getProperty("user.dir");
            pathSK = currentDir.replace(dirFile, "");

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    cp.run();
                    dk.run();
                    mm.run();
                    mb2.run();
                    o.run();
                    sk.pathSK = pathSK;
                    sk.run();
                }
            });
            thread.start();
            thread.join();
            String cpu = cp.name;
            String disk = dk.name;
            String ram = mm.name;
            String mb = mb2.name;
            String os = o.name;
            String socket = sk.name;

            MakeLabel ml = new MakeLabel(os, cpu, mb, ram, disk, socket);

            OdfTextDocument otd = (OdfTextDocument) OdfDocument.loadDocument(pathSK + "\\modelRel\\Model.odt");
            otd.getTableList().get(0).getCellByPosition(0, 0).setDisplayText(ml.getLabel());

            otd.save(pathSK + "\\Relatorio" + date.format(ftd) + ".odt");

            System.out.println("Relatório feito com sucesso :3");

        } catch (Exception e) {
            Log.createLogFile("Error no programa principal  " + e.getMessage());
            System.out.println("Error no programa principal  ");
        }
    }
}
