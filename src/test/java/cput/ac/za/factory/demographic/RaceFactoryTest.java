package cput.ac.za.factory.demographic;

import cput.ac.za.domain.demographic.Race;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceFactoryTest {
    private String race;

    @Before
    public void setUp() throws Exception{
        this.race = "Asian";

    }

    @Test
    public void buildRace(){
        Race course = RaceFactory.buildRace(this.race);
        Assert.assertNotNull(course.getRaceId());
        Assert.assertNotNull(course);
        System.out.print(course);
    }
}
