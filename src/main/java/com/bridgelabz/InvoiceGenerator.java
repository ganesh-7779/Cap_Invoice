/***************************************************************************
 * Purpose : Main class of cab invoice generator Program
 * @author Ganesh Gavhad
 * @Since 01-07-2021
 * @Version 1.0
 ***************************************************************************/
package com.bridgelabz;

public class InvoiceGenerator {
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5.0;
    private static final double COST_PER_KILO = 10.0;

    /**
     * UC1-This method is to calculate the fare of ride with the given time and distance
     * @param distance :first argument of the method
     * @param time     : second argument of the method
     * @return : total fare of cab and if total fare is less than minimum fare will return
     * minimum fare
     */
    public double calculateFare(double distance, double time) {
        double totalFare = (distance * COST_PER_KILO) + (time * COST_PER_MIN);
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }
    /*
     * UC2-This method calculate total fare of all rides
	 * @param rides : first argument of the method takes multiple rides in an array form
	 * @return calculate total fare
	 */
    public double calculateMultipleFare( Ride [] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
    /**
     * UC3
     * @param rideList first argument of the method takes multiple rides in an array form
     * @return  To perform average fair per ride
     *  and total fair with number of rides
     * @throws EnhanceGeneratorException
     */

    public EnhanceInvoice generateEnhanceInvoice(Ride [] rideList) throws EnhanceGeneratorException {
        try {
            double totalFair= calculateMultipleFare(rideList) ;
            int  numOfRides = rideList.length;
            double avgFair = totalFair/ numOfRides ;

            return  new EnhanceInvoice( numOfRides, totalFair, avgFair );
        }
        catch(Exception e) {
            throw new EnhanceGeneratorException(EnhanceGeneratorException.exception.SERVICE_NULL_EXCEPTION);

        }

    }

}



