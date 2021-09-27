package com.bridgelabz.maven.invoicegenerator;


public class CabInvoice 
{
	//normal rides
	private static final int COST_PER_MINUTE = 1;
	private double MIN_COST_PER_KILOMETER = 10.0;
	private static final double MINIMUM_FARE = 5;
	
	//premium rides
	private static final int COST_PER_MINUTE_PREMIUM = 2;
	private static final double MIN_COST_PER_KILOMETER_PREMIUM = 15.0;
	private static final double MINIMUM_FARE_PREMIUM = 20;
	
	/**
	 * calculates fare for a ride
	 * @param distance
	 * @param time
	 * @return
	 */
	public double calculateFare(String category,double distance, int time) {
		if(category.equals("premium")) {
			double totalFare = distance * MIN_COST_PER_KILOMETER_PREMIUM + time * COST_PER_MINUTE_PREMIUM;
			return Math.max(totalFare,MINIMUM_FARE_PREMIUM);
		}else {
			double totalFare = distance * MIN_COST_PER_KILOMETER + time * COST_PER_MINUTE;
			return Math.max(totalFare,MINIMUM_FARE);
		}
	}
	
	/**
	 * method calculates total fares and count total rides
	 * @param rides
	 * @return
	 */
	public InvoiceSummary calculateFare(String category,RidesFare[] rides) {
		double totalFare = 0;
		int totalRides = 0;
		for(RidesFare ride:rides) {
			totalRides++;
			totalFare += this.calculateFare(category,ride.distance,ride.time);
		}
		return new InvoiceSummary(totalRides,totalFare);
	}
}
