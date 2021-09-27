package com.bridgelabz.maven.invoicegenerator;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for Cab invoice generator 
 */
public class CabInvoiceTest 
{

    @Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		CabInvoice invoiceGenerator = new CabInvoice();
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}
}
