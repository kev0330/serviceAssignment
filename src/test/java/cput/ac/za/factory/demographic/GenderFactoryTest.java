package cput.ac.za.factory.demographic;

import cput.ac.za.domain.demographic.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenderFactoryTest {
    private String gender;

    @Before
    public void setUp() throws Exception{
        this.gender = "Male";

    }

    @Test
    public void buildGender(){
        Gender course = GenderFactory.buildGender(this.gender);
        Assert.assertNotNull(course.getGenderId());
        Assert.assertNotNull(course);
        System.out.print(course);
    }
}
