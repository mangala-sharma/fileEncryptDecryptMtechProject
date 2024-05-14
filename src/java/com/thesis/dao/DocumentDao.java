/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.dao;

import com.thesis.entities.Documents;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mangala sharma
 */
public class DocumentDao {
     Connection con;
    
    public DocumentDao(Connection con){
        this.con=con;
    }
     public boolean uploadFile(Documents d){
        boolean f=false;
        
        try{
            String q= "insert into documents(dtitle,dfile,userid) values(?,?,?)";
            PreparedStatement pstmt= con.prepareStatement(q);
           
            pstmt.setString(1,d.getdTitle());
            pstmt.setString(2,d.getdFile());
            
            pstmt.setInt(3,d.getUserId());            
            pstmt.executeUpdate();
            f=true;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return f;
    }
     public List<Documents> getAllPost(){
        
        List<Documents> list=new ArrayList<>();
//        fetch all the posts

            try{
                PreparedStatement p=con.prepareStatement("select * from documents order by did desc");
                
                ResultSet set=p.executeQuery();
                
                while(set.next()){
                    int did=set.getInt("did");
                     String dTitle=set.getString("dtitle");
                    String dFile=set.getString("dfile");
                    Timestamp date=set.getTimestamp("dtime");
                    int userId=set.getInt("userid");
                    Documents doc = new Documents(did, dTitle,dFile, date,userId);
                    
                    list.add(doc);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }

        return list;}
}
