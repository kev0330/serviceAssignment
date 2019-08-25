package cput.ac.za.repository.demographic;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.domain.demographic.Race;
import cput.ac.za.factory.demographic.RaceFactory;
import cput.ac.za.repository.demographic.impl.RaceRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceRepositoryTest {

    private Race employee;
    private RaceRepository repository;

    public Race getSavedEmployee(){
        Set<Race> savedEmployee = this.repository.getAll();
        return savedEmployee.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = RaceRepositoryImpl.getRepository();
        this.employee = RaceFactory.buildRace("African");
    }

    @Test
    public void a_create(){
        Race create = this.repository.create(this.employee);
        System.out.println("In create, created = " + create);
        d_getAll();
        Assert.assertSame(create, this.employee);
    }

    @Test
    public void b_read(){
        Race savedEmployee = getSavedEmployee();
        System.out.println("In read, EmployeeRace = " + savedEmployee.getRaceId());
        Race read = this.repository.read(savedEmployee.getRaceId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedEmployee, read);
    }

    @Test
    public void c_update(){
        String newName = "Asian";
        Race employee = new Race.Builder().copy(getSavedEmployee()).race(newName).build();
        System.out.println("In update, about_to_update = " + employee);
        Race update = this.repository.update(employee);
        Assert.assertSame(newName, update.getRace());
    }

    @Test
    public void d_getAll(){
        Set<Race> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void e_delete(){
        Race saved = getSavedEmployee();
        this.repository.delete(saved.getRace());
        d_getAll();
    }
}
