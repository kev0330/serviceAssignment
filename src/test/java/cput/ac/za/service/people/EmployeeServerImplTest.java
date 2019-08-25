package cput.ac.za.service.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.factory.people.EmployeeFactory;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import cput.ac.za.service.people.Impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServerImplTest {

    private EmployeeServiceImpl service;
    private Employee employee;

    private Employee getSaved(){
        return this.service.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = EmployeeServiceImpl.getService();
        this.employee = EmployeeFactory.buildEmployee("Name","Surname",25);
    }

    @Test
    public void a_create(){
        Employee employee = this.service.create(this.employee);
        System.out.println("In create, create =" + employee);
        Assert.assertNotNull(employee);
        Assert.assertSame(employee,this.employee);
    }

    @Test
    public void b_read(){
        Employee saved = getSaved();
        Employee read = this.service.read(saved.getEmployeeId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update(){
        String newName = "New First Name";
        Employee update = new Employee.Builder().copy(getSaved()).firstName(newName).build();
        System.out.println("In update, updated = " + update);
        this.service.update(update);
        Assert.assertSame(newName, update.getFirstName());
    }

    @Test
    public void d_getAll(){
        Set<Employee> all = this.service.getAll();
        System.out.println("In getall, all = " + all);
    }

    @Test
    public void e_delete(){
        Employee saved = getSaved();
        this.service.delete(saved.getEmployeeId());
        d_getAll();
    }
}
