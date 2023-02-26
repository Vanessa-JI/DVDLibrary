package org.example.dao;

// Interface that defines the methods that must be implemented by any class that plays the role of DAO in this application

// this is an abstract base class -- only its subclasses can be inherited
// would be useful if we had multiple LibraryCollections with similar functionality e.g. CDLibrary, VinylLibrary, etc.

import org.example.dto.DVD;

import java.util.ArrayList;

public interface DVDLibraryDao {
    /**
    *
    */
    DVD addDVD(String title, DVD currDVD);
    /**
     *
     */
    ArrayList<DVD> getAllDVDs();

    /**
     *
     */
    DVD getDVD(String title);

    /**
     *
     */
    DVD removeDVD(String title);

    /**
     *
     */
    DVD editExisting(String title);

//    // providing implementations of the methods (READ UP ON MVC)
//    public void loadLibrary();
//
//    public void saveLibrary();


}
