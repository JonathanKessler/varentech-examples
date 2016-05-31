package com.varentech;

import com.varentech.daoimpl.EntriesDoaImpl;
import com.varentech.entities.Entries;
import com.varentech.entities.EntriesDetail;

import java.util.Calendar;

/**
 * Created by ParksW on 5/25/2016.
 */
public class App {
  //TODO: Implement the main call to take
  public static void main(String[] args) {
    EntriesDoaImpl edi = new EntriesDoaImpl();
    edi.createEntryTable();
    String pathToLocalFile = "/opt/deploya/";

    //TODO: Find a way to get the user's name so that we can add that to the db.

    Entries entry1 = new Entries("Steve", "Howdy.jar", Calendar.getInstance(), pathToLocalFile, "/home/steve/JARS/", "unpackArguments", "executeArguments");
    Entries entry2 = new Entries("Alice", "Hello.jar", Calendar.getInstance(), pathToLocalFile, "/home/alice/Documents/", "unpackArguments", "executeArguments");
    Entries entry3 = new Entries("John", "BestJarEver!.jar", Calendar.getInstance(), pathToLocalFile, "home/john/greatestcreations/", "unpackArguments", "executeArguments");

    EntriesDetail entryDetail1 = new EntriesDetail(entry1.getFileName(), 1.0, entry1.hashCode());
    EntriesDetail entriesDetail2 = new EntriesDetail(entry2.getFileName(), 1.0, entry2.hashCode());
    EntriesDetail entriesDetail3 = new EntriesDetail(entry3.getFileName(), 1.5, entry3.hashCode());


    edi.insert(entry1);
    edi.insert(entry2);
    edi.insert(entry3);
  }
}
