package cput.ac.za.service.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.service.people.Impl.CreateEmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.UUID;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateEmployeeServiceTest {
    private CreateEmployeeServiceImpl service;

    @Before
    public void setUp() throws Exception{
        service = new CreateEmployeeServiceImpl();
    }

    @Test
    public void a_saveEmp(){
        Employee emp1 = service.saveEmp(UUID.randomUUID().toString(), "Kevin", "Yang",23,"Male","Asian");
        System.out.println("Create employee : " + emp1 + "\n");
        Assert.assertNotNull(emp1);
        Assert.assertNotNull(service.empRepository.getAll());
    }

    @Test
    public void b_getEmployeeGender(){
        System.out.println("This emp's gender is : " + service.genderRepository.getAll());
        Assert.assertNotNull(service.genderRepository.getAll());
    }

    @Test
    public void c_getEmpRace(){
        System.out.println("This employee race is : " + service.raceRepository.getAll());
        Assert.assertNotNull(service.raceRepository.getAll());
    }
}
