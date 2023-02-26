// Text-file specific implementation of the DVDLibraryDao interface

package org.example.dao;
import org.example.dto.DVD;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 'implements' keyword shows inheritance relationship
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    // defining two public constant class attributes and a private attribute
    public static final String LIBRARY_FILE = "dvd.txt";
    public static final String DELIMITER = ",";
    private HashMap<String, DVD> dvds = new HashMap<>();

    // method to perform DVD object information unmarshalling
    private DVD unmarshallDVD(String dvdAsText) {
        // split the line read from text file into tokens (DVD object attributes)
        String[] dvdTokens = dvdAsText.split(DELIMITER);

        // generate a new DVD object based on the title retrieved from the text file
        String title = dvdTokens[0];
        DVD dvdFromFile = new DVD(title);

        // set all other instance attributes accordingly and return the DVD object created
        dvdFromFile.setReleaseDate(Integer.parseInt(dvdTokens[1]));
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);
        return dvdFromFile;
    }

    // defining a method to read the library file from comma-separated text file into local memory
    // exception is thrown if there is an error reading the text file
    public void loadLibrary() throws DVDLibraryDaoException {

        // define a new scanner object to read text file line by line
        Scanner scanner;

        // try-catch block handles the exception and prints out an error message if the text file cannot be read
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("Could not load DVD Library file.", e);
        }
        String currentLine;
        DVD currentDVD;

        // read the text file line by line until the end and unmarshall each DVD object from the information in
        // the current line from the text file
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(), currentDVD); // add this DVD object to the library of DVDs
        }
        scanner.close();
    }

    // defining a function to perform data marshalling
    private String marshallDVD(DVD aDVD) {
        // Turning each line of text in the input file into a DVD object
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMpaaRating() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getStudio() + DELIMITER;
        dvdAsText += aDVD.getUserRating();

        return dvdAsText; // return a String object that can be saved in a text file
    }

    // Writes all DVDs in the libraries at the end of program execution to a LIBRARY_FILE.
    // throws ClassRosterDaoException if an error occurs writing to the file
    public void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out; // defining a PrintWriter object to save each line of text to

        // try-catch block handles an exception if DVD data cannot be saved
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException(
                    "Could not save DVD data.", e);
        }

        // Write out the DVD objects to the library file
        String dvdAsText;
        ArrayList<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush(); // force line to be written to file
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
} // End of class definition
