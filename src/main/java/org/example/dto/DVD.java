// This is my data transfer object class definition
// holds all DVD information

package org.example.dto;
public class DVD {

    // defining the fields of the DVD object
    // each attribute is a non-static (instance) property since each DVD has a different value for each field
    private String title;
    private int releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userRating;

    // defining constructors
    // default constructor -- used when inputting DVD objects from the text input file
    public DVD() {}

    // constructor that takes in the title of a DVD only and generates an object from this
    public DVD(String title) {
        this.title = title;
    }

    // defining getters (accessors) and setters (mutators) for all instance attributes
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
