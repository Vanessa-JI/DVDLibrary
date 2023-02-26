package org.example;

import org.example.dto.DVD;

import java.io.*;
import java.util.*;


//public class App() {
//// defining a class attribute -- dvdLibrary
//// define the hashmap (key:value == title:array of other attributes) and add the values in -- UNCOMMENT THE ATTRIBUTE DEFINITION
////    public static HashMap<String, String[]> dvdHashMap = new HashMap<>();
//
//// defining a function to load in the DVD text file -- only role is to get the txt file information into a collection
//// FileNotFoundException throws if the dvd.txt file is not found in the project folder
//// IOException throws if there are no lines in the text file to be read
//public static ArrayList loadLibrary() throws IOException {
//
//        // define new File, FileReader, and BufferedReader objects to read the file line by line
//        File dvdLibFile = new File("dvd.txt");
//        FileReader fileReader = new FileReader(dvdLibFile);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        // THESE WILL BOTH PROBABLY BECOME ATTRIBTUES (NOT SURE WHICH CLASS YET)
//        HashMap<String, String[]> dvdHashMap = new HashMap<>();
//        ArrayList<DVD> library = new ArrayList<>();
//
//        // processing every line of the file one by one
//        while (true) {
//        String fileLine = bufferedReader.readLine();
//
//        // if we reach the end of the file, break out of the while loop
//        if (fileLine == null) {
//        break;
//        }
//
//        // split the contents of this file line into its components and store in an array
//        String[] lineContents = fileLine.split(",");
//
//        // get the first element, set this as the key and then put the rest into the value for the hashmap
//        dvdHashMap.put(lineContents[0], Arrays.copyOfRange(lineContents, 1, lineContents.length));
//
//        // MAY MOVE THESE TWO STEPS TO A DIFFERENT PART OF THE PROGRAM IF THEY DONT FIT IN THE CLASS THIS METHOD IS IN
//        // create a new DVD object from this information, and add it to the DVD library
//        DVD newDVD = createDVD(lineContents[0], dvdHashMap.get(lineContents[0]));
//        addDVD(library, newDVD);
////            System.out.println(library.size());
//
//        } // End of while loop
//
//        return library;
//
//        } // End of loadLibrary function
//
//
//// defining a new function that takes a key value pair (maybe from the hashmap) and turns it into a DVD object
//public static DVD createDVD(String title, String[] fieldsList) {
//
//        // instantiating a new DVD object
//        DVD currDVD = new DVD();
//
//        currDVD.setTitle(title);
//        currDVD.setReleaseDate(Integer.parseInt(fieldsList[0]));
//        currDVD.setMpaaRating(fieldsList[1]);
//        currDVD.setDirectorName(fieldsList[2]);
//        currDVD.setStudio(fieldsList[3]);
//        currDVD.setUserRating(fieldsList[4]);
//
//        return currDVD;
//        }
//
//
//// defining a function that puts the DVD objects into an arraylist of DVD objects (adds to DVD library)
//public static void addDVD(ArrayList<DVD> dvdLibrary, DVD currDVD) {
//        dvdLibrary.add(currDVD);
//        }
//
//
//// defining a function to save the current DVD library (array list of DVD objects) into a hashmap and then into a txt file
//// need to add a try catch to handle exception
//public static void saveLibrary(ArrayList<DVD> dvdLibrary) throws IOException {
//
//        // define the PrintWriter object -- where I am writing the data to
//        PrintWriter out = new PrintWriter(new FileWriter("newDVD.txt"));
//
//        // loop through the DVDLibrary
//        for (DVD currDVD : dvdLibrary) {
//
//        // join all the strings in the array list together with commas
//        String val = new String();
//        val += currDVD.getTitle() + ",";
//        int releaseDate = currDVD.getReleaseDate();
//        val += Integer.toString(releaseDate) + ",";
//        val += currDVD.getMpaaRating() + ",";
//        val += currDVD.getDirectorName() + ",";
//        val += currDVD.getStudio() + ",";
//        val += currDVD.getUserRating();
//
//        // save this DVD's information in its own line in the text file
//        out.println(val);
//
//        }
//
//        // once all DVDs in the library have been processed, force everything to be written and close the stream
//        out.flush();
//        out.close();
//        }
//
//public static void getNewDVD(ArrayList dvdLibrary) {
//
//        // CHANGE ALLLLLLL DATES TO LOCAL DATE FORMAT LATER, KEEP AS INTEGER FOR NOW
////        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
////        LocalDate ld = LocalDate.parse("02/07/2010", formatter);
////        String formatted = ld.format(formatter);
//        // MOVE ALL SCANNERS TO THE VIEW I THINK?
//
//        // instantiate an array list to hold all the DVD information
//        String[] dvdInfo = new String[5];
//
//        System.out.println("Enter the title of the DVD to be added: ");
//        Scanner input = new Scanner(System.in);
//        String newTitle = input.nextLine();
//
//        System.out.println("Enter the release date in the form ddmmyyyy: ");
//        String newReleaseDate = input.nextLine();
//        dvdInfo[0] = newReleaseDate;
//
//        System.out.println("Enter the MPAA rating: ");
//        String mpaa = input.nextLine();
//        dvdInfo[1] = mpaa;
//
//        System.out.println("Enter the director's name: ");
//        String directorName = input.nextLine();
//        dvdInfo[2] = directorName;
//
//        System.out.println("Enter the studio name: ");
//        String studio = input.nextLine();
//        dvdInfo[3] = studio;
//
//        System.out.println("Any additional notes? Give your rating of this DVD: ");
//        String userRating = input.nextLine();
//        dvdInfo[4] = userRating;
//
//        // generate the DVD object and add it to the existing collection
//        DVD currDVD = createDVD(newTitle, dvdInfo);
//        addDVD(dvdLibrary, currDVD);
//
//        }
//
//// define a function to remove a DVD from the collection
//public static ArrayList removeDVD(ArrayList library) {
//
//        // Error handling (i.e. if there is no matching DVD) can be added later --
//        // assuming the user knows which DVDs are in the collection currently
//        Scanner input = new Scanner(System.in);
//        System.out.println("Enter the name of the DVD you wish to remove from the collection: ");
//        String title = input.nextLine();
//
//        // removing the actual DVD
//        // loop through the DVDs in the DVD collection until the one with the matching name is found
//        for (int i = 0; i < library.size(); i++) {
//        DVD curr = (DVD) library.get(i);
//        if (curr.getTitle().equals(title)) {
//        library.remove(i);
//        }
//        }
//        return library;
//        }
//
//public static ArrayList editInformation(ArrayList library) {
//
//        System.out.println("Enter the title of the movie you want to edit the information for: ");
//        Scanner input = new Scanner(System.in);
//        String title = input.nextLine();
//
//        DVD thisDVD = null;
//
//        // find the matching DVD
//        for (int i = 0; i < library.size(); i++) {
//        DVD curr = (DVD) library.get(i);
//        if (curr.getTitle().equals(title)) {
//        thisDVD = curr;
//        break;
//
//        }
//        }
//
//        System.out.println("\nWhat information do you want to edit?");
//        System.out.println("1. Title");
//        System.out.println("2. Release date");
//        System.out.println("3. MPAA rating");
//        System.out.println("4. Director's name");
//        System.out.println("5. Studio");
//        System.out.println("6. User rating");
//
//        int i = input.nextInt();
//
//        switch(i) {
//        case 1:
//        Scanner in = new Scanner(System.in);
//        System.out.println("\nEnter the new title: ");
//        String newTitle = in.nextLine();
//        thisDVD.setTitle(newTitle);
//        System.out.println("\nTitle set to " + "'" + newTitle + "'.");
//        break;
//
//        case 2:
//        Scanner in2 = new Scanner(System.in);
//        System.out.println("\nEnter the new release date: ");
//        String newReleaseDate = in2.nextLine();
//        thisDVD.setReleaseDate(Integer.parseInt(newReleaseDate));
//        System.out.println("\nRelease date set to " + "'" + newReleaseDate + "'.");
//        break;
//
//        case 3:
//        Scanner in3 = new Scanner(System.in);
//        System.out.println("\nEnter the new MPAA rating: ");
//        String newRating = in3.nextLine();
//        thisDVD.setMpaaRating(newRating);
//        System.out.println("\nMPAA rating set to " + "'" + newRating + "'.");
//        break;
//
//        case 4:
//        Scanner in4 = new Scanner(System.in);
//        System.out.println("\nEnter the new director's name: ");
//        String directorName = in4.nextLine();
//        thisDVD.setDirectorName(directorName);
//        System.out.println("\nDirector's name set to " + "'" + directorName + "'.");
//        break;
//
//        case 5:
//        Scanner in5 = new Scanner(System.in);
//        System.out.println("\nEnter the new studio name: ");
//        String studio = in5.nextLine();
//        thisDVD.setStudio(studio);
//        System.out.println("\nStudio name set to " + "'" + studio + "'.");
//        break;
//
//        case 6:
//        Scanner in6 = new Scanner(System.in);
//        System.out.println("\nEnter the new user rating: ");
//        String rating = in6.nextLine();
//        thisDVD.setUserRating(rating);
//        System.out.println("\nUser rating set to " + "'" + rating + "'.");
//        break;
//
//        }
//
//        return library;
//        }
//
//// define a function to list all DVDs in the library
//public static void listAll(ArrayList library) {
//
//        System.out.println("The DVDs in your collection are: ");
//        for (int i = 0; i < library.size(); i++) {
//        DVD curr = (DVD) library.get(i);
//        System.out.println("- " + curr.getTitle());
//        }
//        }
//
//public static void showInformation(ArrayList library) {
//        System.out.println("Enter the title of the DVD you want to view the information of: ");
//        Scanner input = new Scanner(System.in);
//        String title = input.nextLine();
//        DVD thisDVD = null;
//        // find the matching DVD
//        for (int i = 0; i < library.size(); i++) {
//        DVD curr = (DVD) library.get(i);
//        if (curr.getTitle().equals(title)) {
//        thisDVD = curr;
//        break;
//        }
//        }
//
//        System.out.println("\nDVD title: " + title);
//        System.out.println("Release date: " + thisDVD.getReleaseDate());
//        System.out.println("MPAA Rating: " + thisDVD.getMpaaRating());
//        System.out.println("Director's name: " + thisDVD.getDirectorName());
//        System.out.println("Studio: " + thisDVD.getStudio());
//        System.out.println("User rating/notes: " + thisDVD.getUserRating());
//
//        }
//
//public static void searchByTitle(ArrayList library) {
//
//        System.out.println("Enter the title of the DVD you would like to search for: ");
//        Scanner input = new Scanner(System.in);
//        String title = input.nextLine();
//
//        DVD thisDVD = null;
//
//        // find the matching DVD
//        for (int i = 0; i < library.size(); i++) {
//        DVD curr = (DVD) library.get(i);
//        if (curr.getTitle().equals(title)) {
//        thisDVD = curr;
//        break;
//        }
//        }
//
//        // once we get the DVD, we ask -- what would you like to do:
//        /*
//        secondary menu:
//            1. Remove DVD from collection
//            2. Display information
//            3. Edit information
//            4. Back to Main Menu
//         */
//
//
//        }
//
//
//public static void main(String[] args) throws IOException {
//
//        ArrayList library = loadLibrary();
////        getNewDVD(library);
////        library = editInformation(library);
//        showInformation(library);
//        saveLibrary(library);
//
////        saveLibrary();
//        }
//        }
//// DVD Library is just an arrayList of DVD objects
//// iterate through our arrayList one by one
//// each element is a DVD object
//// instantiate a hashmap of key:value == name:other_attributes
//// get the name of the DVD object and set it to the key for the hashmap
//// get the different attributes in the correct order and push them to an array
//// create a new string to be input into the text file -- first the name and then plus all the values in the array, separated by commas
//
//
//
//
//
//
//
//
//
//
//
////        // iterate through the hashmap
////        Set<String> keys = dvdHashMap.keySet();
////        for ( String key : keys ) {
//
////            // make an array of strings separated by commas
////
////            String[] fileLine = new String[dvdHashMap.get(key).length() + 1];
////
////            // create a new DVD object with the key as its name
////            DVD newDVD = new DVD();
////
////            newDVD.setTitle(key);
////
////            // loop through the values array and add each of them as an individual attribute
//
////            System.out.println( key );
//
//// do something with the key and value
//
//// save each element of the HashMap into a line in the text file
//
//
//
////            // creating an instance of the dvd object -- constructor input is the name and then this is used to
////            // create the object -- in the constructor we find the value using the key in the hashmap, and then each
////
////
////
////
////            for (String val : lineContents) {
//////                System.out.println(val);
////            }
//
//// containsKey() function will be useful
