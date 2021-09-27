package com.bridgelabz.maven.invoicegenerator;


public class CabInvoice 
{
	private static final int COST_PER_MINUTE = 1;
	private double MIN_COST_PER_KILOMETER = 10.0;

	public double calculateFare(double distance, int time) {
		return distance * MIN_COST_PER_KILOMETER + time * COST_PER_MINUTE;		
	}
}
