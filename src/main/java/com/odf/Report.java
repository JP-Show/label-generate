package com.odf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.utils.Log;
import com.utils.Regx;

public class Report {

    public static String pickOne(FileReader fr, String start, String end, String item) throws Exception {
        String roll = "unknown";
        try {
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                if (line.contains(start)) {
                    while (!line.contains(end)) {
                        if (line.contains(item)) {
                            roll = line;
                            return format(roll);
                        }
                        line = br.readLine();
                    }
                    return roll;
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            Log.createLogFile("Error pegar uma linha no relatorio - " + e.getMessage());
            System.out.println("Error pegar uma linha no relatorio");
        }
        if (roll == "unknown")
            Log.createLogFile("Error pegar uma linha no relatorio");
        return roll;
    }

    private static String format(String string) throws Exception {
        String result = Regx.cutString("LGA\\d{3,4}|AM\\d|FM\\d ", string);
        return result;
    }

}
