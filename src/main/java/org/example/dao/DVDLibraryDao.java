package org.example.dao;

// Interface that defines the methods that must be implemented by any class that plays the role of DAO in this application

// this is an abstract base class -- only its subclasses can be inherited
// would be useful if we had multiple LibraryCollections with similar functionality e.g. CDLibrary, VinylLibrary, etc.

public interface DVDLibraryDao {

    // providing implementations of the methods (READ UP ON MVC)
    public void loadLibrary();

    public void saveLibrary();


}
