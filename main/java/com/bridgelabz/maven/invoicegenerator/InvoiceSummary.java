package com.bridgelabz.maven.invoicegenerator;

/**
 * summary of rides fare with attributes
 * @author mohammad.musthafa_ym
 *
 */
public class InvoiceSummary {
	
	private final int numOfRides;
	private final double totalFare;
	private final double averageFare;
	
	/**
	 * parameterized constructor to initialize 
	 * @param numOfRides
	 * @param totalFare
	 */
	public InvoiceSummary(int numOfRides, double totalFare) {
		this.numOfRides = numOfRides;
		this.totalFare = totalFare;
		this.averageFare = this.totalFare/this.numOfRides;
	}
	
	//overrides equal method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary that = (InvoiceSummary) obj;
		return numOfRides == that.numOfRides &&
				Double.compare(that.totalFare, totalFare) == 0 &&
				Double.compare(this.averageFare, averageFare) == 0;
	}
}
