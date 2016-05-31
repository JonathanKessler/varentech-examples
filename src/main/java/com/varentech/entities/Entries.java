/*
  Varen Tech: Deploya App
  Created on May 29, 2016
  This is a class for the Entries object
 */

package com.varentech.entities;

import java.util.Date;

public class Entries {
  private String userName;
  private String fileName;
  private Date date = new Date();
  //TODO: These entries must be changed once we find out the data type we will be handling.
  private String pathToLocalFile;
  private String pathToDestination;
  private String unpackArguments;
  private String executeArguments;

  //Default Constructor
  public Entries() {
  }

  //Constructor
  public Entries(String userName, String fileName, Date date, String pathToLocalFile,
                 String pathToDestination, String unpackArguments, String executeArguments) {
    this.userName = userName;
    this.fileName = fileName;
    this.date = date;
    this.pathToLocalFile = pathToLocalFile;
    this.pathToDestination = pathToDestination;
    this.unpackArguments = unpackArguments;
    this.executeArguments = executeArguments;
  }

  //Setters
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public void setTime(Date date) {
    this.date = date;
  }

  public void setPathToLocalFile(String pathToLocalFile) {
    this.pathToLocalFile = pathToLocalFile;
  }

  public void setPathToDestination(String pathToDestination) {
    this.pathToDestination = pathToDestination;
  }

  public void setUnpackArguments(String unpackArguments) {
    this.unpackArguments = unpackArguments;
  }

  public void setExecuteArguments(String executeArguments) {
    this.executeArguments = executeArguments;
  }

  //Getters
  public String getUserName() {
    return userName;
  }

  public String getFileName() {
    return fileName;
  }

  public Date getTime() {
    return date;
  }

  public String getPathToLocalFile() {
    return pathToLocalFile;
  }

  public String getPathToDestination() {
    return pathToDestination;
  }

  public String getUnpackArguments() {
    return unpackArguments;
  }

  public String getExecuteArguments() {
    return executeArguments;
  }

}
