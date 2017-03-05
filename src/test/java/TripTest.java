package test.java;

import main.java.Cab;
import main.java.Trip;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TripTest {

    @Test
    public void calculatatefareEstimate() throws Exception {
        Cab uberX = new Cab(Cab.uberX);
        Trip banerToSwargate = new Trip(uberX,"Baner","Swargate");
        assertThat(banerToSwargate.calculatatefareEstimate(),is(376.2));
    }

}