package com.varentech.deploya_examples.daoimpl;

import com.varentech.deploya_examples.dao.DatabaseInterface;
import com.varentech.deploya_examples.entities.Entries;
import com.varentech.deploya_examples.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by ParksW on 5/26/2016.
 */
public class EntriesDoaImpl implements DatabaseInterface {

  public void createTable() {
    Connection connection = null;
    Statement statement = null;
    try {
      connection = ConnectionConfiguration.getConnection();
      statement = connection.createStatement();
      statement.execute("CREATE TABLE IF NOT EXISTS Entries(      " +
              "ID                      KEY PRIMARY KEY  NOT NULL, " +
              "username                TEXT             NOT NULL, " +
              "time_stamp              TEXT             NOT NULL, " +
              "file_name               TEXT             NOT NULL, " +
              "path_to_local_file      TEXT             NOT NULL, " +
              "path_to_destination     TEXT             NOT NULL, " +
              "unpack_args             TEXT                     , " +
              "execute_args            TEXT             NOT NULL    )"
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
    try {
      Connection connection = ConnectionConfiguration.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(
              "INSERT INTO Entries " +
                      "(username, time_stamp, file_name, path_to_local_file, path_to_destination, unpack_args, execute_args )" +
                      " VALUES (?,?,?,?,?,?,?)"
      );

      preparedStatement.setString(1, entries.getUserName());
      preparedStatement.setString(2, entries.getTime().toString());
      preparedStatement.setString(3, entries.getFileName());
      preparedStatement.setString(4, entries.getPathToLocalFile());
      preparedStatement.setString(5, entries.getPathToDestination());
      preparedStatement.setString(6, entries.getUnpackArguments());
      preparedStatement.setString(7, entries.getExecuteArguments());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public List<Entries> listEntries() {
    return null;
  }

  public void update(Entries entries, int id) {

  }

}
