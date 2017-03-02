package test.java;

import main.java.Cab;
import main.java.Customer;
import main.java.Trip;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {

    @Test
    public void printEmptyMonthlyReport()
    {
        Customer john =  new Customer("John");
        Cab cab = new Cab(Cab.uberGo);
        Trip trip = new Trip(cab);
        trip.start("Wakad","24/02/2017 10:00:00");
        trip.complete("Kothrud","24/02/2017 11:00:00");

        john.completeRide(trip);

        Cab uberX = new Cab(Cab.uberX);
        Trip trip2 = new Trip(uberX);
        trip2.start("Baner","24/02/2017 12:00:00");
        trip2.complete("Swargate","24/02/2017 13:00:00");

        john.completeRide(trip2);

        assertThat(john.printReport(),is(""));
    }
}
