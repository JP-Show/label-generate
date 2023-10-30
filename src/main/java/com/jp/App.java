package com.jp;

import java.io.IOException;

import com.exceptions.myException;
import com.hardware.Cpu;
import com.hardware.Disk;
import com.hardware.Memory;
import com.hardware.Motherboard;
import com.hardware.Os;

public final class App {
    public static void main(String[] args) {
        try {
            System.out.println(Disk.getName());
            System.out.println(Memory.getName());
            System.out.println(Os.getName());
            System.out.println(Cpu.getName());
            System.out.println(Motherboard.getName());
        } catch (myException | IOException e) {
            e.printStackTrace();
        }
    }
}
