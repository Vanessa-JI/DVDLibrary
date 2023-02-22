package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Main {

    // defining a class attribute -- dvdLibrary
    // define the hashmap (key:value == title:array of other attributes) and add the values in -- UNCOMMENT THE ATTRIBUTE DEFINITION
//    public static HashMap<String, String[]> dvdHashMap = new HashMap<>();

    // defining a function to load in the DVD text file -- only role is to get the txt file information into a collection
    // FileNotFoundException throws if the dvd.txt file is not found in the project folder
    // IOException throws if there are no lines in the text file to be read
    public static HashMap loadLibrary() throws IOException {

        // define new File, FileReader, and BufferedReader objects to read the file line by line
        File dvdLibFile = new File("dvd.txt");
        FileReader fileReader = new FileReader(dvdLibFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // THESE WILL BOTH PROBABLY BECOME ATTRIBTUES (NOT SURE WHICH CLASS YET)
        HashMap<String, String[]> dvdHashMap = new HashMap<>();
        ArrayList<DVD> library = new ArrayList<>();

        // processing every line of the file one by one
        while (true) {
            String fileLine = bufferedReader.readLine();

            // if we reach the end of the file, break out of the while loop
            if (fileLine == null) {
                break;
            }

            // split the contents of this file line into its components and store in an array
            String[] lineContents = fileLine.split(",");

            // get the first element, set this as the key and then put the rest into the value for the hashmap
            dvdHashMap.put(lineContents[0], Arrays.copyOfRange(lineContents, 1, lineContents.length));

            // MAY MOVE THESE TWO STEPS TO A DIFFERENT PART OF THE PROGRAM IF THEY DONT FIT IN THE CLASS THIS METHOD IS IN
            // create a new DVD object from this information, and add it to the DVD library
            DVD newDVD = createDVD(lineContents[0], dvdHashMap.get(lineContents[0]));
            addDVD(library, newDVD);
            System.out.println(library.size());

        } // End of while loop

        return dvdHashMap;

    } // End of loadLibrary function


    // defining a new function that takes a key value pair (maybe from the hashmap) and turns it into a DVD object
    public static DVD createDVD(String title, String[] fieldsList) {

        // instantiating a new DVD object
        DVD currDVD = new DVD();

        currDVD.setTitle(title);
        currDVD.setReleaseDate(Integer.parseInt(fieldsList[0]));
        currDVD.setMPAARating(fieldsList[1]);
        currDVD.setDirectorName(fieldsList[2]);
        currDVD.setStudio(fieldsList[3]);
        currDVD.setUserRating(fieldsList[4]);

        return currDVD;
    }


    // defining a function that puts the DVD objects into an arraylist of DVD objects (adds to DVD library)
    public static void addDVD(ArrayList<DVD> dvdLibrary, DVD currDVD) {
            dvdLibrary.add(currDVD);
    }


    // defining a function to save the current DVD library into a hashmap and then into a txt file
    public static void saveLibrary(ArrayList<DVD> dvdLibrary) {


        // turn DVDLibrary into a hashmap
        // DVD Library is just an arrayList of DVD objects
        // iterate through our arrayList one by one
        // each element is a DVD object
        // instantiate a hashmap of key:value == name:other_attributes
        // get the name of the DVD object and set it to the key for the hashmap
        // get the different attributes in the correct order and push them to an array
        // create a new string to be input into the text file -- first the name and then plus all the values in the array, separated by commas











//        // iterate through the hashmap
//        Set<String> keys = dvdHashMap.keySet();
//        for ( String key : keys ) {

//            // make an array of strings separated by commas
//
//            String[] fileLine = new String[dvdHashMap.get(key).length() + 1];
//
//            // create a new DVD object with the key as its name
//            DVD newDVD = new DVD();
//
//            newDVD.setTitle(key);
//
//            // loop through the values array and add each of them as an individual attribute

//            System.out.println( key );
        }
            // do something with the key and value

        // save each element of the HashMap into a line in the text file



//            // creating an instance of the dvd object -- constructor input is the name and then this is used to
//            // create the object -- in the constructor we find the value using the key in the hashmap, and then each
//
//
//
//
//            for (String val : lineContents) {
////                System.out.println(val);
//            }

    // containsKey() function will be useful





    public static void main(String[] args) throws IOException {

        HashMap dvdHashMap = loadLibrary();


//        saveLibrary();


    }
}