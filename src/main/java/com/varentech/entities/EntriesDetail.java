package com.varentech.entities;

/**
 * Created by ParksW on 5/31/2016.
 */
public class EntriesDetail {
  private String fileName;
  private double versionNumber;
  //TODO Create a hashvalue for this class?
  private int hashCode;

  //Default, no args constructor
  public EntriesDetail() {
  }

  public EntriesDetail(String fileName, double versionNumber, int hashCode) {
    this.fileName = fileName;
    this.versionNumber = versionNumber;
    this.hashCode = hashCode;
  }

  //Setters
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public void setVersionNumber(long versionNumber) {
    this.versionNumber = versionNumber;
  }
  //Note: We do not want to set the hashcode! We do not want to chnge it later!

  //Getters
  public String getFileName() {
    return fileName;
  }

  public double getVersionNumber() {
    return versionNumber;
  }

  public int getHashCode() {
    return hashCode;
  }
}
