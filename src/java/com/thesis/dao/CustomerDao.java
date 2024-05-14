/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.dao;

import com.thesis.entities.Customer;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Mangala sharma
 */
public class CustomerDao {
     private Connection con;
    
    //constructor for creating connection
    public CustomerDao(Connection con){
        this.con=con;
    }
    
//    method to insert database
    public boolean saveCustomer(Customer customer){
        boolean f=false;
        try{
            
            String query = "insert into customer( name ,email ,password ) values(?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);
         
            pstmt.setString(1,customer.getName());
            pstmt.setString(2,customer.getEmail());
            pstmt.setString(3,customer.getPassword());
           
            
            pstmt.executeUpdate();
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
    
    public static String passwordHash(String password){
        {
            try{
                MessageDigest md= MessageDigest.getInstance("SHA");
                md.update(password.getBytes());
                byte[] rbt = md.digest();
                StringBuilder sb=new StringBuilder();
                
                for(byte b:rbt){
                    sb.append(String.format("%02x",b));
                }
                return sb.toString();
            }
            catch(Exception e){
                
            }
            return null;
        }
    }

  //get user by user email and user password for login
 public Customer getelementbyemail(String email,String password){
     Customer customer=null;
     try{
     String query="select *from customer where email=? and password=?";
     PreparedStatement pstmt=con.prepareStatement(query);
     pstmt.setString(1, email);
     pstmt.setString(2, password);
     
     ResultSet set=pstmt.executeQuery();
     
     if(set.next()){
         customer=new Customer();
         String name= set.getString("name");
         customer.setName(name);
                
         customer.setId(set.getInt("id"));
         customer.setEmail(set.getString("email"));
         customer.setPassword(set.getString("password"));
        
     }
 }catch(Exception e){
  e.printStackTrace();
}
return customer;}
  public Customer getelementbyemaill(String email){
     Customer customer=null;
     try{
     String query="select *from customer where email=? ";
     PreparedStatement pstmt=con.prepareStatement(query);
     pstmt.setString(1, email);
     
     ResultSet set=pstmt.executeQuery();
     
     if(set.next()){
         customer=new Customer();
         String name= set.getString("name");
         customer.setName(name);
                
         customer.setId(set.getInt("id"));
         customer.setEmail(set.getString("email"));
//         customer.setPassword(set.getString("password"));
        
     }
     }catch(Exception e){
  e.printStackTrace();
}
return customer;}
}
