package org.coolfitted.coolfittedrest.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.coolfitted.coolfittedrest.model.Hat;

public class DatabaseAccess {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/coolfitteddb";
	static final String USER = "root";
	static final String PASS = "";
	static final String homequery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.idimages > 47";
	static final String snapquery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.imagename LIKE '%snap1%'";
	static final String strapquery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.imagename LIKE '%strap1%'";
	static final String newarrquery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.idimages < 36";
	
	
	
	public DatabaseAccess(){
		
	}
	
	public static List<Hat> getHomeHats(){
		List<Hat> hatlist = new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(homequery);
			while (rs.next()){
				String path = rs.getString("imagepath");
				String name = rs.getString("imagename");
				int len = name.length();
				name = name.substring(0,len);
				String title = rs.getString("title");
				String description = rs.getString("description");
				String price = rs.getString("price");
				Hat h = new Hat(path,name,title,price,description);
				hatlist.add(h);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hatlist;
	}
	
	public static List<Hat> getSnapHats(){
		List<Hat> hatlist = new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(snapquery);
			while (rs.next()){
				String path = rs.getString("imagepath");
				String name = rs.getString("imagename");
				int len = name.length();
				name = name.substring(0,len);
				String title = rs.getString("title");
				String description = rs.getString("description");
				String price = rs.getString("price");
				Hat h = new Hat(path,name,title,price,description);
				hatlist.add(h);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hatlist;
	}
	
	public static List<Hat> getStrapHats(){
		List<Hat> hatlist = new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(strapquery);
			while (rs.next()){
				String path = rs.getString("imagepath");
				String name = rs.getString("imagename");
				int len = name.length();
				name = name.substring(0,len);
				String title = rs.getString("title");
				String description = rs.getString("description");
				String price = rs.getString("price");
				Hat h = new Hat(path,name,title,price,description);
				hatlist.add(h);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hatlist;
	}
	
	public static List<Hat> getArrivalHats(){
		List<Hat> hatlist = new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(newarrquery);
			while (rs.next()){
				String path = rs.getString("imagepath");
				String name = rs.getString("imagename");
				int len = name.length();
				name = name.substring(0,len);
				String title = rs.getString("title");
				String description = rs.getString("description");
				String price = rs.getString("price");
				Hat h = new Hat(path,name,title,price,description);
				hatlist.add(h);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hatlist;
	}
	
}
