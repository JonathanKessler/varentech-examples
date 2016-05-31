package com.varentech.deploya_examples;

import com.varentech.deploya_examples.daoimpl.EntriesDetailsDoaImpl;
import com.varentech.deploya_examples.entities.EntriesDetail;

import java.util.Date;

/**
 * Created by ParksW on 5/25/2016.
 */

public class App {

  //This will be final as it should not change. At initial run, the program should be able to create this directory if it is not found.
  final static String pathToLocalFile = "/opt/deploya/";

  public static void main(String[] args) {
    EntriesDetailsDoaImpl eddi = new EntriesDetailsDoaImpl();

    //TODO: Make sure that a directory is located at /opt/deploya/ exists.

    //TODO: if not, create one. then proceed...

    //TODO: Find a way to get the user's name so that we can add that to the db.
    //EXAMPLES
    String userName1 = "parksw@varentech.com";
    String userName2 = "kesslerk@varentech.com";

    //A new instance of Date must be called each time the program is run.
    Date date = new Date();

    //TODO: Find a way to store the Path to where the given file will be stored.
    //EXAMPLES
    String pathDestination1 = "/home/Steve/Code/";
    String pathDestination2 = "/home/Alice/JARS/";

    //TODO: Create a local variable that holds the name of the archive file.
    //EXAMPLES
    String file1 = "File1.jar";
    String file2 = "File1.tar";

    //TODO: Find a way to store the unpacking arguments
    //if no unpacking arguments are given, then unpacking arguement is defined as null.
    //EXAMPLES
    String unpackArgs1 = null;
    String unpackArgs2 = "tar -xf";

    //TODO: Find a way to get the executable arguments
    //EXAMPLES
    String executeArgs1 = "java -jar";
    String executeArgs2 = "java Hello.java";

    //TODO: Using a string builder, the entire execute command can be saved.
    //This will be stored in the DB.
    //EXAMPLES
    executeArgs1 = executeArgs1 + pathToLocalFile + file1;
    executeArgs2 = executeArgs2 + pathToLocalFile + file2;

    //TODO: Save the file from the given path above.
    //???

    //TODO: Find a way to capture the output of the program.
    //EXAMPLES
    String entry1Output = "Alphabetically, anonymously attracting art.";
    String entry2Output = "Being bona-fide beach bums.";


    EntriesDetail entriesDetail1 = new EntriesDetail(userName1, file1, date, pathToLocalFile, pathDestination1, unpackArgs1, executeArgs1, file1.hashCode(), entry1Output);
    EntriesDetail entriesDetail2 = new EntriesDetail(userName2, file2, date, pathToLocalFile, pathDestination2, unpackArgs2, executeArgs2, file2.hashCode(), entry2Output);


    eddi.insert(entriesDetail1);
    // eddi.insert(entriesDetail2);



  }
}
