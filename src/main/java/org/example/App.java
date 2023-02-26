package org.example;

import org.example.controller.DVDLibraryController;
import org.example.dto.DVD;

import java.io.*;
import java.util.*;

public class App {

    public static void main(String[] args) {
        DVDLibraryController controller = new DVDLibraryController();
        controller.run();
    }
}
