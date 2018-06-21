package com.Maveric.Service;

import com.Maveric.DAO.FlightServicesDAO;
import com.Maveric.FlightModel.FlightModel;

public class FlightService {

	


	public boolean flightBuslogic(FlightModel fModel) {
		
		boolean addedtoDBFlag=false;
		
		if (fModel.getFlightname().equalsIgnoreCase("Boeing")) {
			System.out.println("Adding to DB");
			FlightServicesDAO flightServicesDAO =new FlightServicesDAO();
			flightServicesDAO.addFlightToDB(fModel);
			addedtoDBFlag=true;
		} else {
			System.out.println("Am going to make my trip");
		}
		
				
		return addedtoDBFlag;
		
	}
}
