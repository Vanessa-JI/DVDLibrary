// This class orchestrates the application
// it knows what needs to and can be done by each component
// uses DVDLibrary interface to reference the DAO -- unaware of implementation details
package org.example.controller;
import org.example.dao.DVDLibraryDao;
import org.example.dao.DVDLibraryDaoException;
import org.example.dto.DVD;
import org.example.ui.DVDLibraryView;
import java.util.ArrayList;

public class DVDLibraryController {

    // Define two members -- one is DVDLibraryDao, the other is DVDLibraryView
    // This is a use of composition -- DVDLibraryController has-a DVDLibraryView and has-a DVDLibraryDao
    // Also demonstrates dependency injection to keep components loosely coupled
    private DVDLibraryView view;
    private DVDLibraryDao dao;

    // constructor instantiates both the DAO and the View
    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao; // handles retrieval and storage of DVDLibrary data
        this.view = view; // needed for user interaction
    }

    // defining a method that handles editing of DVD object information in the library
    public void editInformation() {
        view.displayEditDVDBanner(); // display banner to announce editing of information
        String title = view.getTitleToSearch(); // view retrieves the title of required DVD from user
        DVD dvd = dao.getDVD(title); // DAO retrieves DVD object using title as a search key
        dao.removeDVD(title); // unedited DVD object is removed from library by DAO
        view.displayDVD(dvd);
        DVD newDVD = view.editDVDInformation(dvd);
        dao.addDVD(newDVD.getTitle(), newDVD); // new edited DVD is returned and added to the library
    }

    // defining a method that handles the removal of required DVD object from the library
    public void removeDVD() {
        view.displayRemoveDVDBanner(); // inform user that they selected to remove DVD
        String title = view.getTitleToSearch(); // view retrieves title of required DVD
        DVD dvd = dao.removeDVD(title); // DAO removes required DVD object from library
        view.displayRemoveResults(dvd); // view informs user if the removal of that DVD was successful
    }

    // defining a method that handles displaying all information about a DVD to a user
    private void viewDVD() {
        view.displayGetDVDBanner();
        String title = view.getTitleToSearch(); // view retrieves title of required DVD
        DVD dvd = dao.getDVD(title); // DAO retrieves DVD object using title as a search key
        view.displayDVD(dvd); // view reports all DVD object information to user
    }

    // defining a method that lists all DVDs currently in the DVD library
    private void listDVDs() {
        view.displayListAllBanner();
        ArrayList<DVD> dvdList = dao.getAllDVDs(); // DAO retrieves all DVDs in the library and returns them as a list
        view.listAll(dvdList); // view lists all DVDs in the library
    }

    private void createDVD() {
        view.displayCreateDVDBanner();
        DVD newDVD = view.getNewDVD(); // view retrieves all information user inputs that is needed to create a new DVD
        dao.addDVD(newDVD.getTitle(), newDVD); // DAO creates a new DVD object and adds it to the library
        view.displayCreateSuccessBanner();
    }

    // private method to get the final menu selection
    private int getUserSelection() {
        return view.getMenuSelection();
    }

    // method to load the DVD library from a comma separated text file
    public void loadLibrary() throws DVDLibraryDaoException {
        view.displayLoadingBanner();
        dao.loadLibrary();
    }

    // method to write the existing library into a comma separated text file
    public void writeLibrary() throws DVDLibraryDaoException {
        view.displayWritingBanner();
        dao.writeLibrary();
    }

    // run method kicks off execution of entire program
    public void run() throws DVDLibraryDaoException {

        // first, the library is loaded from a comma separated text file
        loadLibrary();
        boolean running = true;
        int selection = 0;

        // while loop runs infinitely until manually exited to allow user to continually select menu items
        while (running) {
            selection = getUserSelection();

            // switch-case handles selection of different options by the user
            switch (selection) {
                case 1:
                    createDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editInformation();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    viewDVD();
                    break;
                case 6:
                    // when user selects to exit the program, write the new updated library to the text file and exit
                    writeLibrary();
                    System.out.println("\nGoodbye!");
                    return;
                default:
                    // if user selects an invalid case, they are prompted to pick a valid menu options
                    System.out.println("\nPlease pick a value from 1-6.");
            } // End of switch-case
        } // End of while loop
    } // End of run function
} // End of class definition