package org.example;

public class Library extends MediaCollection{

    // defining default constructor

    // defining static (class) methods


    // defining non-static (instance) methods
    // addDVD takes in a DVD object and adds it to the collection
    // SINCE THESE ALL REQUIRE AN INSTANCE OF DVD, SHOULD I MOVE THEM TO THE DVD CLASS?
    public void addDVD(DVD dvdToAdd) {

        // if the DVD name has already been in the library, ask the user if they want to overwrite

        // print a success message if the user has successfully added a new DVD
    }

    // removeDVD removes an existing DVD object from the collection
    public void removeDVD(DVD dvdToBeRemoved) {

        // attempt to remove DVD
        // if DVD is not in library, throw an error message and ask for a new DVD name
        // otherwise, remove the DVD from the library and give a successful removal message

    }

    // editDVD takes in a DVD object and asks the user what they want to edit, calling the appropriate setter function
    public void editDVD(DVD dvdToEdit) {

        // user inputs the name of the DVD they want to edit
        // user can then select which property they want to edit
        // user is shown the current value of the property and prompted to input what they want to change the property to
        // property is edited using setter method
        // user is shown the new property's value

    }

    public void displayInfo(DVD myDVD) {

        // get and print all the attributes of the DVD object
        System.out.println("Title: " + myDVD.getTitle());
        System.out.println("Release Date: " + myDVD.getReleaseDate());
        System.out.println("MPAA Rating: " + myDVD.getMPAARating());
        System.out.println("Director(s): " + myDVD.getDirectors());
        System.out.println("Studio: " + myDVD.getStudio());
        System.out.println("User Rating: " + myDVD.getUserRating());
        System.out.println("Notes: " + myDVD.getNotes());

    }

    public void listAllDVDs() {

        // list all the DVDs in the library
    }

    public void searchForDVD(String title) {

        // user can search for the DVD by title
        // if title is not found, an error message is returned and user is asked if they want to search again
        // if title is found, user is asked what they want to do with this DVD (remove, edit, display info, return to previous menu)

    }
}
