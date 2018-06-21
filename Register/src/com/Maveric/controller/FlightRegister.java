package com.Maveric.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Maveric.FlightModel.FlightModel;
import com.Maveric.Service.FlightService;

/**
 * Servlet implementation class FlightRegister
 */
//@WebServlet("/FlightRegister")
public class FlightRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
				System.out.println("Welcome to GulfAir");
				String flightname=request.getParameter("FlightName");
				String source=request.getParameter("Source");
				String destination=request.getParameter("Destination");
				String fare=request.getParameter("Fare");
				String numberofseats=request.getParameter("No of Seats");
				String aircraftname=request.getParameter("Aircraft Name");
				String addflightbutton=request.getParameter("submit");
				System.out.println("FlightRegister"+flightname +"Source"+source+"Destination"+destination+"Fare"+fare+"Number of Seats"+numberofseats+"Aircreaft Name"+aircraftname+"Submit"+addflightbutton);
			
				FlightModel fModel=new FlightModel();
				fModel.setFlightname(flightname);
				fModel.setSource(source);
				fModel.setDestination(destination);
				fModel.setFare(fare);
				fModel.setNumberofseats(numberofseats);
				fModel.setAircraftname(aircraftname);

				FlightService fService=new FlightService();
				boolean flag=fService.flightBuslogic(fModel);
				
				if (flag) {
					System.out.println("Flight added to DB");
					request.getRequestDispatcher("Sucess.jsp").forward(request, response);
				}
				else {
					response.sendRedirect("http://www.makemytrip.com");
				}
						
	}

		}
