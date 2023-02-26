package org.example.dto;

import org.example.dao.DVDLibraryDao;

// This is my data transfer object class definition
// holds all DVD information
public class DVD {

    // defining the fields of the DVD object
    // each attribute is a non-static (instance) property since each DVD has a different value for each field
    // COMMENT ON EACH PART AND WHY IT WAS CHOSEN I.E. PUBLIC, STATIC ETC
    private String title;
    private int releaseDate;

    private String mpaaRating; // can take a value of G, M, PG, R, or X
    private String directorName;
    private String studio;

    private String userRating;




//    // there may be multiple directors with first and last names, therefore the director is modelled as an array of directors
//    // MAY NEED TO CHANGE THIS TO AN ARRAY LIST TO MAKE IT DYNAMIC
//    private Director[] directors;
//
//    // release date has a day, month, and year, so the date is modelled as an object
//    private Date releaseDate;
//
//    // SEE IF IT'S NECESSARY TO MODEL THE NOTES AS AN OBJECT ALSO
//    private Note notes;

    // defining constructors
    // default constructor -- used when inputting DVD objects from the text input file
    public DVD() {

    }


    // alternative constructor -- user is adding a new DVD and adds just the title name (could add other arguments if they'd like)


    // defining getters (accessors) and setters (mutators)

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }


}
