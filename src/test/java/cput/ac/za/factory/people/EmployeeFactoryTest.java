package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.factory.people.EmployeeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
    private String testName,testSurname;
    private int testAge;

    @Before
    public void setUp() throws Exception{
        this.testName = "testName";
        this.testSurname = "testSurname";
        this.testAge = 25;
    }

    @Test
    public void buildEmployee(){
        Employee employee = EmployeeFactory.buildEmployee(this.testName,this.testSurname,this.testAge);
        Assert.assertNotNull(employee.getEmployeeId());
        Assert.assertNotNull(employee);
        System.out.print(employee);
    }
}
