package com.odf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.utils.Regx;

public class Report {

    public static String pickOne(FileReader fr, String start, String end, String item) throws Exception {
        String socket = "unknown";
        try {
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                if (line.contains(start)) {
                    while (!line.contains(end)) {
                        if (line.contains(item)) {
                            socket = line;
                            return format(socket);
                        }
                        line = br.readLine();
                    }
                    return socket;
                }
                line = br.readLine();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
        return socket;
    }

    private static String format(String string) throws Exception {
        String result = Regx.cutString("LGA\\d{3,4}|AM\\d|FM\\d ", string);
        return result;
    }

}
