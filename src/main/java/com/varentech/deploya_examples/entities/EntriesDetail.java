package com.varentech.deploya_examples.entities;

import java.util.Date;

/**
 * Created by ParksW on 5/31/2016.
 */
public class EntriesDetail extends Entries {
  private int hashValue;
  private String output;


  //Default, no args constructor
  public EntriesDetail() {
  }

  public EntriesDetail(
          String userName, String fileName, Date date, String pathToLocalFile,
          String pathToDestination, String unpackArguments, String executeArguments,
          int hashValue, String output) {

    super(userName, fileName, date, pathToLocalFile, pathToDestination, unpackArguments, executeArguments);
    this.hashValue = hashValue;
    this.output = output;
  }

  //Setters
  public void setHashValue(int hashValue) {
    this.hashValue = hashValue;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  //Getters
  public int getHashValue() {
    return hashValue;
  }

  public String getOutput() {
    return output;
  }

}
