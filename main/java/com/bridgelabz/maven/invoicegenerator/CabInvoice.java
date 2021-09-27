package com.bridgelabz.maven.invoicegenerator;


public class CabInvoice 
{
	private static final int COST_PER_MINUTE = 1;
	private double MIN_COST_PER_KILOMETER = 10.0;
	private static final double MINIMUM_FARE = 5;
	
	/**
	 * calculates fare for a ride
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(double distance, int time) {
		double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_MINUTE;	
		return Math.max(totalFare,MINIMUM_FARE);
	}
	
	/**
	 * method calculates total fares and count total rides
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(RidesFare[] rides) {
		double totalFare = 0;
		int totalRides = 0;
		for(RidesFare ride:rides) {
			totalRides++;
			totalFare += this.calculateFare(ride.distance,ride.time);
		}
		
		return new InvoiceSummary(totalRides,totalFare);
	}
}
