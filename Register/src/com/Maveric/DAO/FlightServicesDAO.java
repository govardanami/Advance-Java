package com.Maveric.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.Maveric.FlightModel.FlightModel;

public class FlightServicesDAO {
	
	
	static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/fbooking";
	
	// Database credentials
	static final String USER = "GOVA";
	static final String PASS = "Reddy";
	
	public void addFlightToDB(FlightModel fModel) {
	
		Connection conn=null;
		Statement stmt=null;
		//learn Exception handling and Error
		try
		{
			//Am registering the Driver here
			Class.forName(JDBC_DRIVER);
			
			//getting the connection
			conn=DriverManager.getConnection(DB_URL,USER,PASS);
			
			// creating the statement
			stmt=conn.createStatement();
			
			String query="INSERT INTO FlightService (FLIGHTNAME, SOURCE, DESTINATION, FARE, NUMBEROFSEATS, AIRCRAFTNAME ) "
					+ "VALUES ('"+fModel.getFlightname()+"','"+fModel.getSource()+"','"+fModel.getDestination()+"','"+fModel.getFare()+"','"+fModel.getNumberofseats()+"','"+fModel.getAircraftname()+"');";
			System.out.println("Query used is "+query);
			int result=stmt.executeUpdate(query);
			
		}
	catch (Exception E) {
		System.out.println("Exception Occured"+E);
	}
	
			finally {
				if(conn!=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			}

		
		
		
		// TODO: handle exception
	}		
	}
	
	