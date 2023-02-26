package org.example.ui;

// This class handles all the UI logic
// Uses UserIO interface to interact with the user -- completely aware of implementation ddetails


import org.example.dto.DVD;

import java.util.ArrayList;
import java.util.Scanner;

// define a member that is of type UserIO
public class DVDLibraryView {

    public int getMenuSelection() {

        Scanner input = new Scanner(System.in);
        System.out.println("\n==== DVD LIBRARY MAIN MENU ====");
        System.out.println("1. Add DVD to collection");
        System.out.println("2. Remove DVD from collection");
        System.out.println("3. Edit an existing DVD");
        System.out.println("4. List all DVDs in collection");
        System.out.println("5. Search for DVD by title");
        System.out.println("6. Exit\n");

        return input.nextInt();

    } // End of getMenuSelection function

    // defining a new function that takes a key value pair (maybe from the hashmap) and turns it into a DVD object
    public DVD createDVD(String title, String[] fieldsList) {

        // instantiating a new DVD object
        DVD currDVD = new DVD();
        currDVD.setTitle(title);
        currDVD.setReleaseDate(Integer.parseInt(fieldsList[0]));
        currDVD.setMpaaRating(fieldsList[1]);
        currDVD.setDirectorName(fieldsList[2]);
        currDVD.setStudio(fieldsList[3]);
        currDVD.setUserRating(fieldsList[4]);

        return currDVD;
    } // End of createDVD method

    public DVD getNewDVD() {

        // instantiate an array list to hold all the DVD information
        String[] dvdInfo = new String[5];

        System.out.println("Enter the title of the DVD to be added: ");
        Scanner input = new Scanner(System.in);
        String newTitle = input.nextLine();

        System.out.println("Enter the release date in the form ddmmyyyy: ");
        String newReleaseDate = input.nextLine();
        dvdInfo[0] = newReleaseDate;

        System.out.println("Enter the MPAA rating: ");
        String mpaa = input.nextLine();
        dvdInfo[1] = mpaa;

        System.out.println("Enter the director's name: ");
        String directorName = input.nextLine();
        dvdInfo[2] = directorName;

        System.out.println("Enter the studio name: ");
        String studio = input.nextLine();
        dvdInfo[3] = studio;

        System.out.println("Any additional notes? Give your rating of this DVD: ");
        String userRating = input.nextLine();
        dvdInfo[4] = userRating;

        // generate the DVD object and add it to the existing collection
        DVD currDVD = createDVD(newTitle, dvdInfo);

        return currDVD;
    } // End of getNewDVD method

    public void displayCreateDVDBanner() {
        System.out.println("=== Create DVD ===\n");
    }

    public void displayCreateSuccessBanner() {
        System.out.println("DVD successfully created.");
        // FIND A WAY FOR THE CLICK ENTER THIGN TO WORK
    }

// define a function to list all DVDs in the library
    public static void listAll(ArrayList<DVD> dvds) {
        System.out.println("The DVDs in your collection are: ");
        for (DVD currentDVD: dvds) {
            System.out.println("- " + currentDVD.getTitle());
        }
    } // End of listAll method

    public void displayListAllBanner() {
        System.out.println("=== List all DVDs ===\n");
    }

    public void displayGetDVDBanner() {
        System.out.println("=== Display DVD ===");
    }

    public String getTitleToSearch() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the title of the DVD you'd like to see the information for: ");
        String title = input.nextLine();
        return title;
    }

    public void displayDVD(DVD dvd) {

        if (dvd != null) {
            System.out.println("\nDVD title: " + dvd.getTitle());
            System.out.println("Release date: " + dvd.getReleaseDate());
            System.out.println("MPAA Rating: " + dvd.getMpaaRating());
            System.out.println("Director's name: " + dvd.getDirectorName());
            System.out.println("Studio: " + dvd.getStudio());
            System.out.println("User rating/notes: " + dvd.getUserRating());
        } else {
            System.out.println("DVD not found in library. Please enter another title.");
        }
    } // End of display DVD method

} // End of class definition
