// This class handles all the UI logic
// Uses UserIO interface to interact with the user -- completely aware of implementation details
// No other component is allowed to interact with the user

package org.example.ui;

import org.example.dto.DVD;
import java.util.ArrayList;
import java.util.Scanner;

public class DVDLibraryView {

    public void displayLoadingBanner() {
        System.out.println("=== Loading in DVD Library ===");
    }

    public void displayWritingBanner() {
        System.out.println("=== Saving DVD Library ===");
    }

    public void displayEditDVDBanner() {
        System.out.println("=== Edit existing DVD ===");
    }

    public void displayRemoveDVDBanner() {
        System.out.println("=== Remove DVD ===");
    }

    public void displayRemoveResults(DVD dvd) {
        if (dvd != null) {
            String title = dvd.getTitle();
            System.out.println("\n'" + title + "' successfully removed.");
        } else {
            System.out.println("DVD not found.");
        }
    }

    // This prints out the main menu to the user
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
    }

    // defining a new function that takes the appropriate field information and turns it into a DVD object
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

        // set all attributes as appropriate
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
    }

    public void displayCreateDVDBanner() {
        System.out.println("=== Create DVD ===\n");
    }

    public void displayCreateSuccessBanner() {
        System.out.println("DVD successfully created.");
    }

    // define a function to list all DVDs in the library
    public static void listAll(ArrayList<DVD> dvds) {
        System.out.println("The DVDs in your collection are: ");
        for (DVD currentDVD: dvds) {
            System.out.println("- " + currentDVD.getTitle());
        }
    }

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
    }

    public DVD editDVDInformation(DVD dvd) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat information do you want to edit?");
        System.out.println("1. Title");
        System.out.println("2. Release date");
        System.out.println("3. MPAA Rating");
        System.out.println("4. Director's name");
        System.out.println("5. Studio");
        System.out.println("6. User rating/notes");

        int selection = input.nextInt();

        // depending on which option the user selects, they can update a different attribute
        switch (selection) {
            case 1:
                Scanner in = new Scanner(System.in);
                System.out.println("\nEnter the new title: ");
                String newTitle = in.nextLine();
                dvd.setTitle(newTitle);
                System.out.println("\nTitle set to " + "'" + newTitle + "'.");
                break;

            case 2:
                Scanner in2 = new Scanner(System.in);
                System.out.println("\nEnter the new release date: ");
                String newReleaseDate = in2.nextLine();
                dvd.setReleaseDate(Integer.parseInt(newReleaseDate));
                System.out.println("\nRelease date set to " + "'" + newReleaseDate + "'.");
                break;

            case 3:
                Scanner in3 = new Scanner(System.in);
                System.out.println("\nEnter the new MPAA rating: ");
                String newRating = in3.nextLine();
                dvd.setMpaaRating(newRating);
                System.out.println("\nMPAA rating set to " + "'" + newRating + "'.");
                break;

            case 4:
                Scanner in4 = new Scanner(System.in);
                System.out.println("\nEnter the new director's name: ");
                String directorName = in4.nextLine();
                dvd.setDirectorName(directorName);
                System.out.println("\nDirector's name set to " + "'" + directorName + "'.");
                break;

            case 5:
                Scanner in5 = new Scanner(System.in);
                System.out.println("\nEnter the new studio name: ");
                String studio = in5.nextLine();
                dvd.setStudio(studio);
                System.out.println("\nStudio name set to " + "'" + studio + "'.");
                break;

            case 6:
                Scanner in6 = new Scanner(System.in);
                System.out.println("\nEnter the new user rating: ");
                String rating = in6.nextLine();
                dvd.setUserRating(rating);
                System.out.println("\nUser rating set to " + "'" + rating + "'.");
                break;
        } // End of switch statement

        return dvd;

    } // End of editDVDInformation method
} // End of class definition
