package com.jp;

import java.io.IOException;

import com.entities.Cpu;
import com.entities.Motherboard;
import com.exceptions.myException;

public final class App {
    public static void main(String[] args) {
        try {
            System.out.println(Cpu.getName());
            System.out.println(Motherboard.getName());
        } catch (myException | IOException e) {
            e.printStackTrace();
        }
    }
}
