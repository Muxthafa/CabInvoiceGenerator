package com.bridgelabz.maven.invoicegenerator;

import static org.junit.Assert.assertTrue;

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
    
}
