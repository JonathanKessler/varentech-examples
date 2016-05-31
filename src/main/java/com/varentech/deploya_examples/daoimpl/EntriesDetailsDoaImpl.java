package com.varentech.deploya_examples.daoimpl;

import com.varentech.deploya_examples.dao.DatabaseInterface;
import com.varentech.deploya_examples.entities.Entries;
import com.varentech.deploya_examples.entities.EntriesDetail;
import com.varentech.deploya_examples.util.ConnectionConfiguration;

import java.sql.*;
import java.util.List;

/**
 * Created by ParksW on 5/31/2016.
 */
public class EntriesDetailsDoaImpl implements DatabaseInterface {
  public void createTable() {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = ConnectionConfiguration.getConnection();
      statement = connection.createStatement();
      statement.execute("CREATE TABLE IF NOT EXISTS Entries_Details(    " +
              "FOREIGN KEY(foreign_key)     REFERENCES  Entries(id),  " +
              "file_name        TEXT        NOT NULL,                 " +
              "version          INTEGER     NOT NULL,                 " +
              "hash_value       INTEGER     NOT NULL                   )"
      );
    } catch (SQLException se) {
      se.printStackTrace();
    }
  }

  public List<Entries> listEntries() {
    return null;
  }

  public void insert(EntriesDetail entriesDetail) throws NullPointerException {
    //Set the default of Foreign Keys on
    /*
    try{
      Connection connection = ConnectionConfiguration.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("PRAGMA FOREIGN_KEYS = TRUE ;");
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    */

    //Inserting into the Entries table in the DB.
    try {
      Connection connection = ConnectionConfiguration.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(
              "INSERT INTO Entries " +
                      "(time_stamp, username, file_name, path_to_local_file, path_to_destination, unpack_args, execute_args) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?)"
      );
      preparedStatement.setString(1, entriesDetail.getTime().toString());
      preparedStatement.setString(2, entriesDetail.getUserName());
      preparedStatement.setString(3, entriesDetail.getFileName());
      preparedStatement.setString(4, entriesDetail.getPathToLocalFile());
      preparedStatement.setString(5, entriesDetail.getPathToDestination());
      preparedStatement.setString(6, entriesDetail.getUnpackArguments());
      preparedStatement.setString(7, entriesDetail.getExecuteArguments());
      preparedStatement.executeUpdate();
    } catch (SQLException se) {
      se.printStackTrace();
    }
    //Select the Entries id and storing that into a local variable using the time stamp.
    try {
      Connection connection = ConnectionConfiguration.getConnection();
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(
              "SELECT id FROM Entries WHERE time_stamp = " + "'" + entriesDetail.getTime() + "'"
      );
      int id = resultSet.getInt("id");

      PreparedStatement preparedStatement = connection.prepareStatement(
              "INSERT INTO Entries_Details " +
                      "(entries_id, file_name, hash_value, output)" +
                      "VALUES (?,?,?,?)"
      );

      preparedStatement.setString(1, String.valueOf(id));
      preparedStatement.setString(2, entriesDetail.getFileName());
      preparedStatement.setString(3, String.valueOf(entriesDetail.getHashValue()));
      preparedStatement.setString(4, String.valueOf(entriesDetail.getOutput()));
      preparedStatement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /*
      try {
        Connection connection = ConnectionConfiguration.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Entries_Details " +
                        "(entries_id, file_name, hash_value, output)" +
                        "VALUES (?,?,?)"
        );

        preparedStatement.setString(1, resultSet);
        preparedStatement.setString(2, entriesDetail.getFileName());
        preparedStatement.setString(3, String.valueOf(entriesDetail.getHashValue()));
        preparedStatement.setString(4, String.valueOf(entriesDetail.getOutput()));
        preparedStatement.executeUpdate();

      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
  */
  public void update(Entries entries, int id) {

  }
}

