/***************************************************************************
 * Purpose : Test cases for the cab invoice generator
 * @author Ganesh Gavhad
 * @Since 10-08-2021
 * @Version 1.0
 ***************************************************************************/
package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {


         // this teat cae to return fare, distance and time is given
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        double distance =2.0;
        double time = 20.0;
        double  fare = invoice.calculateFare(distance,time);
        Assert.assertEquals(40.0, fare,0.0 );
        }

        // actual fare is 2.2, but we are passing test case for return
        // minimum fare which is 5.
    @Test
    public void givenDistanceAndTime_ShouldMinimumFare(){
        InvoiceGenerator invoice = new InvoiceGenerator();
        double distance =0.2;
        double time = 0.2;
        double  fare = invoice.calculateFare(distance,time);
        Assert.assertEquals(5.0, fare,0.0 );
    }

    //this test case to return Total fare and minimum fare using distance and time is given

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoice = new InvoiceGenerator();

        Ride[] rides = { new Ride(2.0, 5), new Ride(0.5, 5),
                new Ride(0.1, 1), };
        double totalFare =invoice.calculateMultipleFare(rides);
        Assert.assertEquals(40, totalFare, 0.0);
    }
}

