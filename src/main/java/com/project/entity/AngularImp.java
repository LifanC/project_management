package com.project.entity;

import java.sql.*;

public class AngularImp{
	Connection conn=DbConnection.getConnection();
	
	public void updateProjectData(Project project) throws SQLException {
		    PreparedStatement updateProductid = null;
		    PreparedStatement updateQuantity = null;
		    String updateString = "update product_object.project set product_object.project.name = ?, product_object.project.count = ?, product_object.project.price = ?, product_object.project.daytime = ? where id = ?";
		    try {		      
		    	conn.setAutoCommit(false);
		        updateProductid = conn.prepareStatement(updateString);
		            updateProductid.setString(1, project.getName());
		            updateProductid.setInt(2, project.getCount());
		            updateProductid.setInt(3, project.getPrice());
		            updateProductid.setString(4, project.getDaytime());
		            updateProductid.setInt(5, project.getId());
		            updateProductid.executeUpdate();
		        
		    } catch (Exception e ) {
		        System.out.println(e.getMessage());
		        if (conn != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                conn.rollback();
		            } catch(SQLException excep) {
		                System.out.println(excep.getMessage());
		            }
		        }
		    } finally {
		    	conn.setAutoCommit(true);
		        if (updateProductid != null) {
		            updateProductid.close();
		        }
		        if (updateQuantity != null) {
		            updateQuantity.close();
		        }
		        
		    }
		
	}
	
	public void updateCount(Project project) throws SQLException {
	    PreparedStatement updateProductid = null;
	    PreparedStatement updateQuantity = null;
	    String updateString = "update product_object.project set product_object.project.count = ? where id = ?";
	    try {		      
	    	conn.setAutoCommit(false);
	        updateProductid = conn.prepareStatement(updateString);
	            updateProductid.setInt(1, project.getCount());
	            updateProductid.setInt(2, project.getId());
	            updateProductid.executeUpdate();
	        
	    } catch (Exception e ) {
	        System.out.println(e.getMessage());
	        if (conn != null) {
	            try {
	                System.err.print("Transaction is being rolled back");
	                conn.rollback();
	            } catch(SQLException excep) {
	                System.out.println(excep.getMessage());
	            }
	        }
	    } finally {
	    	conn.setAutoCommit(true);
	        if (updateProductid != null) {
	            updateProductid.close();
	        }
	        if (updateQuantity != null) {
	            updateQuantity.close();
	        }
	        
	    }
	
}
	
	
}
