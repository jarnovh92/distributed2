package com.dev;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joren
 */
@ManagedBean(name = "categoriesBean")
@SessionScoped
public class CategoriesBean {
    
    //resource injection
    @Resource(name="jdbc/JaJo")
    private DataSource ds;
        
    public List<Categories> getCategoriesList() throws SQLException{
        
        if(ds==null){
            throw new SQLException("Can't get data source");
        }	
        //get database connection
	Connection con = ds.getConnection();
		
	if(con==null){
            throw new SQLException("Can't get database connection");
        }
	PreparedStatement ps = con.prepareStatement("select * from jajodb.category"); 
		
	//get customer data from database
	ResultSet rs =  ps.executeQuery();
                
        List<Categories> list = new ArrayList<>();
        
        while(rs.next()){
            Categories cat = new Categories();
            cat.setName(rs.getString("name"));
            cat.setId(rs.getInt("id"));
            //store all data into a List
            list.add(cat);	
	}
        
        return list;
   }
}
