package org.example.dao;

// extends keyword demonstrates an inheritance relationship -- Exception is the parent class and
// DVDLibraryDaoException is the derived class
public class DVDLibraryDaoException extends Exception {

        public DVDLibraryDaoException(String message) {
            super(message);
        }

        public DVDLibraryDaoException(String message, Throwable cause) {
            super(message, cause);
        }
}
