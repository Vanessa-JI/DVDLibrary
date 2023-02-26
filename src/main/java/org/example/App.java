package org.example;

import org.example.controller.DVDLibraryController;
import org.example.dao.DVDLibraryDao;
import org.example.dao.DVDLibraryDaoException;
import org.example.dao.DVDLibraryDaoFileImpl;
import org.example.ui.DVDLibraryView;

public class App {

    // driving force of the application -- instantiates necessary layers (View, DAO, and Controller) and starts execution
    public static void main(String[] args) throws DVDLibraryDaoException {
        DVDLibraryView myView = new DVDLibraryView();
        DVDLibraryDao myDao = new DVDLibraryDaoFileImpl();
        DVDLibraryController controller = new DVDLibraryController(myDao, myView);
        controller.run();
    }
}
