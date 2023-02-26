package org.example.ui;

// This class handles all the UI logic
// Uses UserIO interface to interact with the user -- completely aware of implementation ddetails


// define a member that is of type UserIO
public class DVDLibraryView {

    public static void showMainMenu() {
        System.out.println("==== DVD LIBRARY MAIN MENU ====");
        System.out.println("1. Add DVD to collection");
        System.out.println("2. Remove DVD from collection");
        System.out.println("3. Edit an existing DVD");
        System.out.println("4. List all DVDs in collection");
        System.out.println("5. Search for DVD by title");
        System.out.println("6. Exit");
    }

}
