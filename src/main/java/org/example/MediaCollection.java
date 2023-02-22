package org.example;

// this is an abstract base class -- only its subclasses can be inherited
// would be useful if we had multiple LibraryCollections with similar functionality e.g. CDLibrary, VinylLibrary, etc.

// MAYBE MAKE THIS AN INTERFACE INSTEAD????
public interface MediaCollection {

    // providing implementations of the methods (READ UP ON MVC)
    public void loadLibrary();

    public void saveLibrary();


}
