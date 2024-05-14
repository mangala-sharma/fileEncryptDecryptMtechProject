/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Mangala sharma
 */
public class ConnectionProvider {
     private static Connection con;
    public static Connection getConnection(){
        
            try{
                
                if(con==null){
            
                //load class
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                //create connection
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shreesitaramradharaman","root","root");
                }
            }   
           
            catch(Exception e){
                e.printStackTrace();
            } 
        
        return con;
        
        
    }
}
