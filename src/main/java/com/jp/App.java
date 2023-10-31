package com.jp;

import java.io.IOException;

import com.exceptions.myException;
import com.hardware.Cpu;
import com.hardware.Disk;
import com.hardware.Memory;
import com.hardware.Motherboard;
import com.hardware.Os;
import com.hardware.Socket;
import com.label.MakeLabel;

public final class App {
    public static void main(String[] args) {
        try {
            String cpu = Cpu.getName();
            String disk = Disk.getName();
            String ram = Memory.getName();
            String mb = Motherboard.getName();
            String os = Os.getName();
            String socket = Socket.getName();

            MakeLabel ml = new MakeLabel(os, cpu, mb, ram, disk, socket);
            System.out.println(ml.getLabel());

            Runtime.getRuntime().exec("cmd /c start cmd.exe /K echo " + ml.getLabel());
        } catch (myException | IOException e) {
            System.out.println(e.getMessage() + " " + e.getCause());
        }
    }
}
