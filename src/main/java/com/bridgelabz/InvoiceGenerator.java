/***************************************************************************
 * Purpose : Main class of cab invoice generator Program
 * @author Ganesh Gavhad
 * @Since 01-07-2021
 * @Version 1.0
 ***************************************************************************/
package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InvoiceGenerator {
    private static final int COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5.0;
    private static final double COST_PER_KILO = 10.0;
    public ArrayList<EnhanceInvoice> userRide = null;
    public Map<String, ArrayList<EnhanceInvoice>> capBook = new HashMap<>();
    public String userId;

    public enum RideMode {

        NORMAL(10.0, 1, 5.0), PREMIUM(15.0, 2, 20.0);

        private double COST_PER_KILO;
        private int COST_PER_MIN;
        private double MINIMUM_FARE;

        RideMode(double COST_PER_KILO, int COST_PER_MIN, double MINIMUM_FARE) {
            this.COST_PER_KILO =COST_PER_KILO;
            this.COST_PER_MIN = COST_PER_MIN;
            this.MINIMUM_FARE = MINIMUM_FARE;
        }
    }

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
    public double calculateMultipleFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    /**
     * UC3
     *
     * @param rideList
     * @return To perform average fair per ride
     * and total fair with number of rides
     * @throws EnhanceGeneratorException
     */

    public EnhanceInvoice generateEnhanceInvoice(Ride[] rideList) throws EnhanceGeneratorException {
        try {
            double totalFair = calculateMultipleFare(rideList);
            int numOfRides = rideList.length;
            double avgFair = totalFair / numOfRides;

            return new EnhanceInvoice(numOfRides, totalFair, avgFair);
        } catch (Exception e) {
            throw new EnhanceGeneratorException(EnhanceGeneratorException.exception.SERVICE_NULL_EXCEPTION);

        }

    }

        public HashMap InvoiceSrviceWithUserID (Ride[]rideList) throws EnhanceGeneratorException {
            try {
                System.out.println("Enter User Id");
                Scanner sc = new Scanner(System.in);
                userId = sc.next();
                double totalFair = calculateMultipleFare(rideList);
                int numOfRides = rideList.length;
                double avgFair = totalFair / numOfRides;

                EnhanceInvoice obj = new EnhanceInvoice(numOfRides, totalFair, avgFair);
                userRide = new ArrayList<>();
                userRide.add(obj);
                capBook.put(userId, userRide);
                System.out.println(capBook.toString());
            } catch (Exception e) {
                throw new EnhanceGeneratorException(EnhanceGeneratorException.exception.SERVICE_NULL_EXCEPTION);

            }
            return (HashMap) capBook;
        }

    public EnhanceInvoice InvoiceForRideMode(String userId,Ride[] rideList) throws EnhanceGeneratorException {
        try {
            double totalFair = calculateMultipleFare(rideList);
            int numOfRides = rideList.length;
            double avgFair = totalFair / numOfRides;

            return new EnhanceInvoice(numOfRides, totalFair, avgFair);
        } catch (Exception e) {
            throw new EnhanceGeneratorException(EnhanceGeneratorException.exception.SERVICE_NULL_EXCEPTION);

        }

    }
        public static void main (String[]args) throws EnhanceGeneratorException {
            InvoiceGenerator cap = new InvoiceGenerator();
            cap.InvoiceSrviceWithUserID(new Ride[]{new Ride(2.0, 5, RideMode.NORMAL), new Ride(0.5, 5, RideMode.NORMAL),
                    new Ride(0.1, 1, RideMode.NORMAL),});
        }
    }



