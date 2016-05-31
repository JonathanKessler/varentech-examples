package com.varentech.dao;

import com.varentech.entities.Entries;

import javax.sql.DataSource;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ParksW on 5/26/2016.
 */

//TODO: Add other implementation methods!
public interface EntriesDao {
  /*
  This method is used to initialize
  database resources i.e. a connection
   */
  void setDataSource(DataSource ds);

  /*
  This method is used to create
  a record in the Entries table.
   */
  void insert(String userName, String fileName, Calendar time, String pathToLocalFile, String pathToDestination, String unpackArguments, String executeArguments);

  /*
  This method is used to list down
  all the records from the Entries table.
   */
  List<Entries> listEntries();

  void update(Entries entries, int id);
}
