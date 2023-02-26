// Interface that defines the methods that must be implemented by any class that plays the role of DAO in this application
// Would be useful if we had multiple LibraryCollections with similar functionality e.g. CDLibrary, VinylLibrary, etc.

package org.example.dao;
import org.example.dto.DVD;
import java.util.ArrayList;

public interface DVDLibraryDao {
    /**
    * addDVD method generates DVD objects from user input information and adds DVD objects to the library Arraylist.
    */
    DVD addDVD(String title, DVD currDVD);

    /**
     * getAllDVDs method lists the titles of all DVD objects currently in the library
     */
    ArrayList<DVD> getAllDVDs();

    /**
     * getDVD methods allows to search by DVD title. Displays information for a DVD (if found in the library) to the user
     */
    DVD getDVD(String title);

    /**
     * removeDVD function receives user input DVD title and removes the DVD from the existing library if it is present.
     * If not, an error message is printed to the user that deletion of this DVD could not be achieved.
     */
    DVD removeDVD(String title);

    /**
     * editExisting allows the user to find a DVD by searching by title. The user can then select the attributes of this
     * DVD object that they wish to edit the values of.
     */
    DVD editExisting(String title);

    /**
     * loadLibrary reads DVD object information line by line from a comma-separated text file. If file cannot be read,
     * an exception is thrown and handled.
     * @throws DVDLibraryDaoException
     */
    void loadLibrary() throws DVDLibraryDaoException;

    /**
     * writeLibrary is called only at the end of the program execution. Current library stored in local memory is saved
     * to a comma-separated text file. If action cannot be completed, an exception is thrown and handled.
     * @throws DVDLibraryDaoException
     */
    void writeLibrary() throws DVDLibraryDaoException;

} // End of class definition
