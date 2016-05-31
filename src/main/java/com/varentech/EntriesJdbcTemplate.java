package com.varentech;

import com.varentech.dao.EntriesDao;
import com.varentech.entities.Entries;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Calendar;
import java.util.List;

public class EntriesJdbcTemplate implements EntriesDao {

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplateObject;

  public void setDataSource(DataSource ds) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }

  //TODO: Find a way to insert into a SQLite database
  public void insert(String userName, String fileName, Calendar time, String pathToLocalFile, String pathToDestination, String unpackArguments, String executeArguments) {
  }

  //TODO:  Find a way to select everything from this table and print it out.
  public List<Entries> listEntries() {
    return null;
  }

  //TODO: Find a way to update the Entries table.
  public void update(Entries entries, int id) {

  }
}