package cput.ac.za.service.demographic;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.factory.demographic.GenderFactory;
import cput.ac.za.service.demographic.Impl.GenderServiceImpl;
import cput.ac.za.service.people.Impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GenderServiceTest {

    private GenderServiceImpl service;
    private Gender employee;

    private Gender getSaved(){
        return this.service.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = GenderServiceImpl.getService();
        this.employee = GenderFactory.buildGender("Male");
    }

    @Test
    public void a_create(){
        Gender employee = this.service.create(this.employee);
        System.out.println("In create, create =" + employee);
        Assert.assertNotNull(employee);
        Assert.assertSame(employee,this.employee);
    }

    @Test
    public void b_read(){
        Gender saved = getSaved();
        Gender read = this.service.read(saved.getGenderId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update(){
        String newName = "Female";
        Gender update = new Gender.Builder().copy(getSaved()).genderName(newName).build();
        System.out.println("In update, updated = " + update);
        this.service.update(update);
        Assert.assertSame(newName, update.getGenderName());
    }

    @Test
    public void d_getAll(){
        Set<Gender> all = this.service.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void e_delete(){
        Gender saved = getSaved();
        this.service.delete(saved.getGenderId());
        d_getAll();
    }
}
