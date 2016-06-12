package com.dev;
/**
 * @author Joren
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.annotation.Resource;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
 

@ManagedBean(name = "categoriesBean")
@SessionScoped
public class CategoriesBean {

    //resource injection
    @Resource(name="jdbc/JaJo")
    private DataSource ds;
                
    public List<Categories> getCategoriesList() {
        List<Categories> list = new ArrayList<>();
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            if(ds==null){
                throw new SQLException("Can't get data source");
            }
            //get database connection
            con = ds.getConnection();
		
            if(con==null){
		throw new SQLException("Can't get database connection");
            }
            ps = con.prepareStatement("select * from category");
            rs = ps.executeQuery();
            while (rs.next()) {
                Categories cat = new Categories();
                cat.setName(rs.getString("name"));
                cat.setId(rs.getLong("id"));
                list.add(cat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
