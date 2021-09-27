package com.bridgelabz.maven.invoicegenerator;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Cab invoice generator 
 */
public class CabInvoiceTest 
{
	CabInvoice invoiceGenerator = null;
	@Before
	public void intializeClaa() {
		invoiceGenerator = new CabInvoice();
	}
    @Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}
    
    @Test
    public void givenDistanceAndTimeForMultipleRidesShouldReturnAggregate() {
    	RidesFare[] rides = { new RidesFare(5.0,5), new RidesFare(2.0,3)};
    	InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
    	InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2,78.0);
    	Assert.assertEquals(expectedInvoiceSummary,summary);
    }
    
    @Test
    public void givenUserIdShouldReturnListOfRidesAndInvoice() {
    	RidesFare[] ridesOfUser1 = { new RidesFare(5.0,5), new RidesFare(2.0,3)};
    	RidesFare[] ridesOfUser2 = { new RidesFare(3.0,6), new RidesFare(7.0,9)};
    	RidesFare[] ridesOfUser3 = { new RidesFare(2.0,7), new RidesFare(4.0,8)};
    	
    	Map<Integer,RidesFare[]> rideRepository = new HashMap<>();
		rideRepository.put(1, ridesOfUser1);
		rideRepository.put(2, ridesOfUser2);
		rideRepository.put(3, ridesOfUser3);
		
		InvoiceSummary summary = invoiceGenerator.calculateFare(rideRepository.get(1));
    	InvoiceSummary expctdInvoiceSummary = new InvoiceSummary(2,78.0);
    	Assert.assertEquals(expctdInvoiceSummary,summary);
    }
    
}
