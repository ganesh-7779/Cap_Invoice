/*
 ******************************************************************
 * Purpose : POJO class for Multiple ride
 * @Author : Ganesh Gavhad
 * @since  : 10.08.2021
 * @version: 1.0
 ******************************************************************
 */
package com.bridgelabz;

public class Ride {
    double distance;
    double time;

    //Parameterized constructor
    public Ride(double distance, double time, InvoiceGenerator.RideMode normal){
        this.distance=distance;
        this.time=time;
    }
}
