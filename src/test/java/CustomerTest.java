package test.java;

import main.java.Cab;
import main.java.Customer;
import main.java.Trip;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {

    @Test
    public void printReport() throws Exception {
        Customer john =  new Customer("John");

        Cab uberGo = new Cab(Cab.uberGo);
        Trip wakadToKothrud = new Trip(uberGo, "Baner", "Swargate");
        wakadToKothrud.start("Wakad","24/02/2017 10:00:00");
        wakadToKothrud.complete("Kothrud","24/02/2017 11:00:00");
        john.completeTrip(wakadToKothrud);

        Cab uberX = new Cab(Cab.uberX);
        Trip wakadToKothrudUberX = new Trip(uberX, "Baner", "Swargate");
        wakadToKothrudUberX.start("Wakad","24/02/2017 10:00:00");
        wakadToKothrudUberX.complete("Kothrud","24/02/2017 11:00:00");
        john.completeTrip(wakadToKothrudUberX);

        Cab uberSUV = new Cab(Cab.uberSUV);
        Trip wakadToKothrudSUV = new Trip(uberSUV, "Baner", "Swargate");
        wakadToKothrudSUV.start("Wakad","24/02/2017 10:00:00");
        wakadToKothrudSUV.complete("Kothrud","24/02/2017 11:00:00");
        john.completeTrip(wakadToKothrudSUV);

        String expected = "Customer Name: John\n" +
                "\n" +
                "Trip from Wakad to Kothrud\n" +
                "Trip distance is 15.0 Km\n" +
                "Trip duration is 60.0 Minutes\n" +
                "Fare for this trip is 198.55\n" +
                "\n" +
                "Trip from Wakad to Kothrud\n" +
                "Trip distance is 15.0 Km\n" +
                "Trip duration is 60.0 Minutes\n" +
                "Fare for this trip is 282.15\n" +
                "\n" +
                "Trip from Wakad to Kothrud\n" +
                "Trip distance is 15.0 Km\n" +
                "Trip duration is 60.0 Minutes\n" +
                "Fare for this trip is 428.45\n" +
                "\n" +
                "Your total cab expenses are 909.15";

        assertThat(john.printReport(),is(expected));
    }



}