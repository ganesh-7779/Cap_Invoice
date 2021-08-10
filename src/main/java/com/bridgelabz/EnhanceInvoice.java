/**
 * Purpose : POJO for EnhanceInvoice
 * @author : Ganesh Gavhad
 * @since : 10/8/2021
 * @Version : 1.0
 */
package com.bridgelabz;

public class EnhanceInvoice {
    public int numberOfRides;
    public double fair;
    public double avgFairPerRide;



    public EnhanceInvoice(int numberOfRides, double fair, double avgFairPerRide) {
        this.numberOfRides = numberOfRides;
        this.fair = fair;
        this.avgFairPerRide = avgFairPerRide;
    }
    public int getNumberOfRides() {
        return numberOfRides;
    }

    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    public double getFair() {
        return fair;
    }

    public void setFair(double fair) {
        this.fair = fair;
    }

    public double getAvgFairPerRide() {
        return avgFairPerRide;
    }

    public void setAvgFairPerRide(double avgFairPerRide) {
        this.avgFairPerRide = avgFairPerRide;
    }
    public String toString() {
        return "EnhanceInvoice [numberOfRides=" + numberOfRides + ", fair=" + fair + ", avgFairPerRide=" + avgFairPerRide+ "]";
    }

}
