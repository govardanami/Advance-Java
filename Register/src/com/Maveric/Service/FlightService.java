package com.Maveric.Service;

import com.Maveric.DAO.FlightServicesDAO;
import com.Maveric.FlightModel.FlightModel;

public class FlightService {

	


	public boolean flightBuslogic(FlightModel fModel) {
		
		boolean addedtoDBFlag=false;
		boolean result=false;
		if (fModel.getFlightname().equalsIgnoreCase("Boeing")) {
			System.out.println("Adding to DB");
			FlightServicesDAO flightServicesDAO =new FlightServicesDAO();
			boolean res=flightServicesDAO.addFlightToDB(fModel);
			addedtoDBFlag=true;
			if (res) {
				result=true;
			} else {

			}
			return result;
		} else {
			System.out.println("Am going to make my trip");
		}
		
				
		return addedtoDBFlag;
		
	}
}
