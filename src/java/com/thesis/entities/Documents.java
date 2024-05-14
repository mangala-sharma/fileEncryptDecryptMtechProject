/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.entities;

import java.sql.Blob;
import java.sql.Timestamp;

/**
 *
 * @author Mangala sharma
 */
public class Documents {
    private int dId;
    private String dTitle;
    private String dFile;
    private Timestamp dDate;
    private int userId;
    
    public Documents(){
        
    }

    public Documents(int dId, String dTitle, String dFile, Timestamp dDate, int userId) {
        this.dId = dId;
        this.dTitle = dTitle;
        this.dFile = dFile;
        this.dDate = dDate;
        this.userId = userId;
    }

    public Documents(String dTitle, String dFile, Timestamp dDate, int userId) {
        this.dTitle = dTitle;
        this.dFile = dFile;
        this.dDate = dDate;
        this.userId = userId;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdTitle() {
        return dTitle;
    }

    public void setdTitle(String dTitle) {
        this.dTitle = dTitle;
    }

    public String getdFile() {
        return dFile;
    }

    public void setdFile(String dFile) {
        this.dFile = dFile;
    }

    public Timestamp getdDate() {
        return dDate;
    }

    public void setdDate(Timestamp dDate) {
        this.dDate = dDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
