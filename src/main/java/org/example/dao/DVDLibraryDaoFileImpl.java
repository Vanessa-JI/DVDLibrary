package org.example.dao;

import org.example.dto.DVD;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Text-file specific implementation of the DVDLibraryDao interface

public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    public static final String LIBRARY_FILE = "dvd.txt";
    public static final String DELIMITER = ",";

    // defining a private member to the class
    private HashMap<String, DVD> dvds = new HashMap<>();

    // DVD information unmarshalling --
    private DVD unmarshallDVD(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DVD dvdFromFile = new DVD(title);
        dvdFromFile.setReleaseDate(Integer.parseInt(dvdTokens[1]));
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);
        return dvdFromFile;
    }

    // defining a method to read the library file into local memory
    public void loadLibrary() throws DVDLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("Could not load DVD Library file.", e);
        }
        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);

            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){
        // Turning each line of text in the input file into a DVD object
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getUserRating();

        return dvdAsText;
    }

    /**
     * Writes all DVDs in the libraries at the end of program execution to a LIBRARY_FILE.
     *
     * throws ClassRosterDaoException if an error occurs writing to the file
     */
    public void writeLibrary() throws DVDLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        // Write out the DVD objects to the roster file.
        String dvdAsText;
        ArrayList<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }

    @Override
    public DVD addDVD(String title, DVD currDVD) {
        DVD newDVD = dvds.put(title, currDVD);
        return newDVD;
    }

    @Override
    public ArrayList<DVD> getAllDVDs() {
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title) {
        return dvds.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        return dvds.remove(title);
    }

    @Override
    public DVD editExisting(String title) {
        return null;
    }


    // defining default constructor
//
//    // defining static (class) methods
//
//
//    // defining non-static (instance) methods
//    // addDVD takes in a DVD object and adds it to the collection
//    // SINCE THESE ALL REQUIRE AN INSTANCE OF DVD, SHOULD I MOVE THEM TO THE DVD CLASS?
//    // MAY NEED TO MOVE ALL OF THESE METHODS INTO THE MEDIA CONTROLLER CLASS????
//    public void addDVD(DVD dvdToAdd) {
//
//        // if the DVD name has already been in the library, ask the user if they want to overwrite
//
//        // print a success message if the user has successfully added a new DVD
//    }
//
//    // removeDVD removes an existing DVD object from the collection
//    public void removeDVD(DVD dvdToBeRemoved) {
//
//        // attempt to remove DVD
//        // if DVD is not in library, throw an error message and ask for a new DVD name
//        // otherwise, remove the DVD from the library and give a successful removal message
//
//    }
//
//    // editDVD takes in a DVD object and asks the user what they want to edit, calling the appropriate setter function
//    public void editDVD(DVD dvdToEdit) {
//
//        // user inputs the name of the DVD they want to edit
//        // user can then select which property they want to edit
//        // user is shown the current value of the property and prompted to input what they want to change the property to
//        // property is edited using setter method
//        // user is shown the new property's value
//
//    }
//
//    public void displayInfo(DVD myDVD) {
//
//        // get and print all the attributes of the DVD object
//        System.out.println("Title: " + myDVD.getTitle());
//        System.out.println("Release Date: " + myDVD.getReleaseDate());
//        System.out.println("MPAA Rating: " + myDVD.getMpaaRating());
//        System.out.println("Director: " + myDVD.getDirectorName());
//        System.out.println("Studio: " + myDVD.getStudio());
//        System.out.println("User Rating: " + myDVD.getUserRating());
//
//    }
//
//    public void listAllDVDs() {
//
//        // list all the DVDs in the library
//    }
//
//    public void searchForDVD(String title) {
//
//        // user can search for the DVD by title
//        // if title is not found, an error message is returned and user is asked if they want to search again
//        // if title is found, user is asked what they want to do with this DVD (remove, edit, display info, return to previous menu)
//
//    }
//
//
//    @Override
//    public void loadLibrary() {
//
//    }
//
//    @Override
//    public void saveLibrary() {
//
//    }
}
