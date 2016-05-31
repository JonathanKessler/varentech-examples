package com.varentech.daoimpl;

import com.varentech.dao.DatabaseInterface;
import com.varentech.entities.Entries;
import com.varentech.entities.EntriesDetail;
import com.varentech.util.ConnectionConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

  public void insert(EntriesDetail entriesDetail) {
    try {
      Connection connection = ConnectionConfiguration.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(
              "INSERT INTO Entries_Details " +
                      "(file_name, version_number, hash_value)" +
                      "VALUES (?,?,?)"
      );

      preparedStatement.setString(1, entriesDetail.getFileName());
      preparedStatement.setString(2, String.valueOf(entriesDetail.getVersionNumber()));
      preparedStatement.setString(3, String.valueOf(entriesDetail.getHashCode()));
      preparedStatement.executeUpdate();

    } catch (SQLException se) {
      se.printStackTrace();
    }
  }


  public List<Entries> listEntries() {
    return null;
  }

  public void update(Entries entries, int id) {

  }
}
