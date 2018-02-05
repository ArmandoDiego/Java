//package com.db.diego;
//
//import java.sql.Statement;
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.List;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		try {
//			PreparedStatement preparedStatement = null;
//			updateContact(preparedStatement,33,"Diego");
//			getResults(preparedStatement);
//		} catch (SQLException e) {
//			System.out.println("Something went wrong" +e.getMessage());
//		}
//
//	}
//	
//	public static void updateContact(PreparedStatement preparedStatement, int phone, String name ) throws SQLException{
//		Connection dbConnection = null;
//		String updateTableSQL= "UPDATE " + TABLE_CONTACTS + " SET " + 
//				COLUMN_PHONE + "= ? " + 
//				" WHERE " + COLUMN_NAME + "= ? ";
//		try {
//			dbConnection = getDBConnection();
//			preparedStatement = dbConnection.prepareStatement(updateTableSQL);
//			preparedStatement.setInt(1, phone);
//			preparedStatement.setString(2, name);
//			// execute update SQL stetement
//			preparedStatement.executeUpdate();
//			System.out.println("Record is updated "+ name);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());		
//		}finally {
//			if (preparedStatement != null) {
//				preparedStatement.close();
//			}
//
//			if (dbConnection != null) {
//				dbConnection.close();
//			}
//		}
//	}
//	
//	public static void getResults(PreparedStatement statement){
//		try {
//			ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
//			while(results.next()){
//				System.out.println(results.getString(COLUMN_NAME)+ " " +
//								   results.getInt(COLUMN_PHONE)+ " " + 
//								   results.getString(COLUMN_EMAIL));
//			}
//			results.close();
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());		
//		}
//		
//	}
//	public static void insertConctact(Statement statement, String name, int phone, String email ){
//		try {
//			statement.execute("INSERT INTO "+ TABLE_CONTACTS +
//					" (" + COLUMN_NAME + ", " +
//					     COLUMN_PHONE + ", " +
//					     COLUMN_EMAIL + " ) " +
//					     "VALUES('" + name + "', " + phone + ", '" + email + "')");
//		} catch (SQLException e) {
//				System.out.println(e.getMessage());		
//		}
//	}
//	
//	public static void deleteContact(Statement statement, String name){
//		try {
//			statement.execute("DELETE FROM" + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + " = " + name);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	public static void dropTable(Statement statement){
//		try {
//			statement.execute("DROP TABLE IF EXISTS "+TABLE_CONTACTS);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());		
//		}
//	}
//	
//	public static void createTable(Statement statement){
//		try {
//			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +
//					 " (" + COLUMN_NAME + " text, " +
//					 	   COLUMN_PHONE + " integer, " +
//					       COLUMN_EMAIL +  " text" 	+
//					 	   ")");
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());		
//		} 
//	}
//	
//
//	
//	
//	
//
//}
