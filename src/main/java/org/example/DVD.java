package org.example;

public class DVD {

    // defining the fields of the DVD object
    // each attribute is a non-static (instance) property since each DVD has a different value for each field
    // COMMENT ON EACH PART AND WHY IT WAS CHOSEN I.E. PUBLIC, STATIC ETC
    private String title;
    private String Studio;
    private String MPAARating; // can take a value of G, M, PG, R, or X
    private int userRating;




    // there may be multiple directors with first and last names, therefore the director is modelled as an array of directors
    // MAY NEED TO CHANGE THIS TO AN ARRAY LIST TO MAKE IT DYNAMIC
    private Director[] directors;

    // release date has a day, month, and year, so the date is modelled as an object
    private Date releaseDate;

    // SEE IF IT'S NECESSARY TO MODEL THE NOTES AS AN OBJECT ALSO
    private Note notes;

    // defining constructors

    // defining getters (accessors)

    public String getTitle() {
        return title;
    }

    public String getStudio() {
        return Studio;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public int getUserRating() {
        return userRating;
    }

    public Director[] getDirectors() {
        return directors;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Note getNotes() {
        return notes;
    }


    // defining setters (mutators)
}
