package com.varentech.dao;

import com.varentech.entities.Entries;

import java.util.List;

/**
 * Created by ParksW on 5/26/2016.
 */

//TODO: Add other implementation methods!
public interface DatabaseInterface {

  /*
  This method is used to create a new table in the database if
  needed
   */
  void createTable();
  /*
  This method is used to list down
  all the records from the Entries table.
   */
  List<Entries> listEntries();

  void update(Entries entries, int id);
}
