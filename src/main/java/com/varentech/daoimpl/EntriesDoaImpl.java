package com.varentech.daoimpl;

import com.varentech.dao.EntriesDao;
import com.varentech.entities.Entries;
import com.varentech.util.ConnectionConfiguration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ParksW on 5/26/2016.
 */
public class EntriesDoaImpl implements EntriesDao {

  public void createEntryTable() {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = ConnectionConfiguration.getConnection();
      statement = connection.createStatement();
      statement.execute("CREATE TABLE IF NOT EXISTS ENTRIES(" +
              "ID KEY PRIMARY KEY NOT NULL, " +
              "PERSON_NAME    TEXT    NOT NULL, " +
              "UPLOAD_TIME    TIMESTAMP NOT NULL, " +
              "PROGRAM_OUTPUT OUTPUT  NOT NULL, " +
              "JAR_NAME       TEXT    NOT NULL, " +
              "HASH_VALUE     DOUBLE  NOT NULL); "
      );
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException se) {
          se.printStackTrace();
        }
      } else if (connection != null) {
        try {
          connection.close();
        } catch (SQLException se) {
          se.printStackTrace();
        }
      }
    }
  }

  public void insert(Entries entries) {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = ConnectionConfiguration.getConnection();
      statement = connection.prepareCall("INSERT INTO ENTRIES " +
              "(PERSON_NAME, UPLOAD_TIME, PROGRAM_OUTPUT, JAR_NAME, HASH_VALUE) VALUES (?,?,?,?,?)");
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (statement != null) {
        try {
          statement.close();
        } catch (SQLException se) {
          se.printStackTrace();
        }
      } else if (connection != null) {
        try {
          connection.close();
        } catch (SQLException se) {
          se.printStackTrace();
        }
      }
    }
  }

  public void setDataSource(DataSource ds) {

  }

  public void insert(String userName, String fileName, Calendar time, String pathToLocalFile, String pathToDestination, String unpackArguments, String executeArguments) {

  }

  public List<Entries> listEntries() {
    return null;
  }

  public void update(Entries entries, int id) {

  }
}
