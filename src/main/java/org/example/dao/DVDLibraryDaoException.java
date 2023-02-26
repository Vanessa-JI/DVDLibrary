package org.example.dao;

// extends keyword demonstrates an inheritance relationship -- Exception is the parent class and
// DVDLibraryDaoException is the derived class
public class DVDLibraryDaoException extends Exception {

        // exception is thrown when an error is encountered in reading in or writing the library from/to a comma
        // separated text file.
        public DVDLibraryDaoException(String message, Throwable cause) {
            super(message, cause);
        }
}
