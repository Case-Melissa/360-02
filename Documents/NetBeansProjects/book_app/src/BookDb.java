/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mcase
 */

public class BookDb {
public static int save(String callno,String name,String author,String publisher,int quantity){
	int status=0;
	try{
            try (Connection con = DB.getConnection()) {
                PreparedStatement ps=con.prepareStatement("insert into books(callno,name,author,publisher,quantity) values(?,?,?,?,?)");
                ps.setString(1,callno);
                ps.setString(2,name);
                ps.setString(3,author);
                ps.setString(4,publisher);
                ps.setInt(5,quantity);
                status=ps.executeUpdate();
            }
	}catch(Exception e){System.out.println(e);}
	return status;
}
}
