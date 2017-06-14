package org.coolfitted.coolfittedrest.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.coolfitted.coolfittedrest.model.Hat;

public class DatabaseAccess {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://sylvester-mccoy-v3.ics.uci.edu/inf124-db-002";
    static final String USER = "inf124-db-002";
    static final String PASS = "K5GLfG5ho!!t";
	static final String homequery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.idimages > 47";
	static final String snapquery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.imagename LIKE '%snap1%'";
	static final String strapquery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.imagename LIKE '%strap1%'";
	static final String newarrquery = "SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images INNER JOIN details ON images.imagename=details.imagename AND images.idimages < 36";
	
	
	public DatabaseAccess(){
		
	}
	public static boolean deleteOrder(int orderid){
		int rs = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			rs = stmt.executeUpdate("DELETE FROM orders WHERE idorders='"+orderid+"'");
				
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs>0;
	}
	public static String insertOrder(MultivaluedMap<String, String> formParams){
		String ide = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			boolean rs = stmt.execute("INSERT INTO orders (firstname,lastname,phonenumber,email,shippingaddress,city,state,zipcode,shippingmethod,creditname,cardnumber,cvv,expirationdate,totalprice,quantity) VALUES ('"+formParams.getFirst("fname")+"','"+formParams.getFirst("lname")+"','"+formParams.getFirst("phone")+"','"+formParams.getFirst("email")+"','"+formParams.getFirst("street")+"','"+formParams.getFirst("city")+"','"+formParams.getFirst("state")+"','"+formParams.getFirst("zip")+"', 'No shipping','"+formParams.getFirst("owner")+"','"+formParams.getFirst("card")+"','"+formParams.getFirst("cvv")+"','"+formParams.getFirst("date")+"','"+formParams.getFirst("total")+"','"+formParams.getFirst("quant")+"')");
			String selectlastorderIDquery = "SELECT idorders FROM orders order by idorders DESC LIMIT 1";
            ResultSet idrs = stmt.executeQuery(selectlastorderIDquery);
            idrs.next();
            ide = idrs.getString("idorders");
				
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ide;
	}
	
	public static String updateOrder(MultivaluedMap<String, String> formParams){
		String ide = "";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet idrs = stmt.executeQuery("SELECT * FROM orders ORDER BY idorders DESC LIMIT 1");
			idrs.next();
			String id = idrs.getString("idorders");
			boolean rs = stmt.execute("UPDATE orders SET firstname = '"+formParams.getFirst("fname")+"', lastname = '"+formParams.getFirst("lname")+"', phonenumber = '"+formParams.getFirst("phone")+"', email = '"+formParams.getFirst("email")+"', shippingaddress = '"+formParams.getFirst("street")+"', city = '"+formParams.getFirst("city")+"', state = '"+formParams.getFirst("state")+"', zipcode = '"+formParams.getFirst("zip")+"', shippingmethod = 'No Shipping' WHERE idorders = '"+id+"'");
			String selectlastorderIDquery = "SELECT idorders FROM orders order by idorders DESC LIMIT 1";
            ResultSet idrs2 = stmt.executeQuery(selectlastorderIDquery);
            idrs2.next();
            ide = idrs2.getString("idorders");
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return ide;
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
	public static List<Hat> getHatDetails(String item){
		List<Hat> hatlist = new ArrayList<>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			for(int i = 1;i < 4;i++){
				String itemName = item.substring(0, item.length()-1)+String.valueOf(i);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT images.imagepath, images.imagename, details.title, details.description, details.price FROM images LEFT JOIN details ON images.imagename=details.imagename WHERE images.imagename = '"+itemName+"'");
				while(rs.next()){
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
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hatlist;
	}	
	
}
