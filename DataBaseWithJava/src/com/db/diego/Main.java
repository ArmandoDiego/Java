package com.db.diego;

import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static final String DB_NAME="music.db";
	public static final String CONNECTION_STRING="jdbc:sqlite:C:\\Users\\HP\\Desktop\\" + DB_NAME;
	public static final String TABLE_CONTACTS="contacts";
	public static final String COLUMN_NAME="name";
	public static final String COLUMN_PHONE= "phone";
	public static final String COLUMN_EMAIL= "email";
	
	public static void main(String[] args) {
		try {
			Connection conn= DriverManager.getConnection(CONNECTION_STRING);
//			conn.setAutoCommit(false);
			Statement statement = conn.createStatement();
			statement.execute("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
							 " (" + COLUMN_NAME + " text, " +
							 	   COLUMN_PHONE + " integer, " +
							       COLUMN_EMAIL +  " text" 	+
							 	   ")"); 
			
		
			insertConctact(statement,"amor",55455,"tcs@gmailsss.com");
			updateContact(statement,5555,"amor");
			
		
			
//			statement.executeUpdate("UPDATE contacts SET phone='3411184189' WHERE name='Esmeralda'");
//			statement.execute("DELETE FROM contacts where name='Matilde'");
//			statement.execute("SELECT * FROM contacts");
//			ResultSet results= statement.getResultSet();
			
			ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
			while(results.next()){
				System.out.println(results.getString(COLUMN_NAME)+ " " +
								   results.getInt(COLUMN_PHONE)+ " " + 
								   results.getString(COLUMN_EMAIL));
			}
			results.close();
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("Something went wrong" +e.getMessage());
		}

	}
	
	public static void insertConctact(Statement statement, String name, int phone, String email ){
		try {
			statement.execute("INSERT INTO "+ TABLE_CONTACTS +
					"(" + COLUMN_NAME + ", " +
					     COLUMN_PHONE + ", " +
					     COLUMN_EMAIL + " ) " +
					     "VALUES('" + name + "', " + phone + ", '" + email + "')");
		} catch (SQLException e) {
				System.out.println(e.getMessage());		
		}
	}

	public static void updateContact(Statement statement, int phone, String name ){
		try {
			statement.executeUpdate("UPDATE " + TABLE_CONTACTS + " SET " + 
//			COLUMN_PHONE + "= '55455' + 
			" WHERE " + COLUMN_NAME + "=" + name +" ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());		
		}
	}
//
//statement.execute("DELETE FROM " + TABLE_CONTACTS +
//					  " WHERE " + COLUMN_NAME + "='Esme'");

	
	
	

}
