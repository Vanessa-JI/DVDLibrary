package org.example.controller;

// This class orchestrates the application
// it knows what needs to and can be done by each component
// uses DVDLibrary interface to reference the DAO -- unaware of implementation details

import org.example.ui.DVDLibraryView;

import java.util.Scanner;

public class DVDLibraryController {

    // define two members -- one is DVDLibrary, the other is DVDLibraryView??????
    // This is a use of composition -- DVDLibraryController has-a DVDLibraryView
    private DVDLibraryView view = new DVDLibraryView();

    // private method to get the final menu selection
    private int getUserSelection() {
        return view.getMenuSelection();
    }

    public void run() {

        boolean running = true;
        int selection = 0;
        while (running) {

            selection = getUserSelection();

            switch (selection) {
                case 1:
                    System.out.println("Add DVD");
                    break;
                case 2:
                    System.out.println("Remove DVD");
                    break;
                case 3:
                    System.out.println("Edit existing DVD");
                    break;
                case 4:
                    System.out.println("List all DVDs");
                    break;
                case 5:
                    System.out.println("Search for a DVD");
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("\nPlease pick a value from 1-6.");

            } // End of switch-case
        } // End of while loop
    } // End of run function
} // End of class definition
