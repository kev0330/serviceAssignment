package cput.ac.za.repository.People;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.factory.people.EmployeeFactory;
import cput.ac.za.repository.people.EmployeeRepository;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private Employee employee;
    private EmployeeRepository repository;

    public Employee getSavedEmployee(){
        Set<Employee> savedEmployee = this.repository.getAll();
        return savedEmployee.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("Name","Surname",25);
    }

    @Test
    public void a_create(){
        Employee create = this.repository.create(this.employee);
        System.out.println("In create, created = " + create);
        d_getAll();
        Assert.assertSame(create, this.employee);
    }

    @Test
    public void b_read(){
        Employee savedEmployee = getSavedEmployee();
        System.out.println("In read, EmployeeID = " + savedEmployee.getEmployeeId());
        Employee read = this.repository.read(savedEmployee.getEmployeeId());
        System.out.println("In read, read = " + read);
        Assert.assertEquals(savedEmployee, read);
    }

    @Test
    public void c_update(){
        String newName = "New LastName of employee";
        Employee employee = new Employee.Builder().copy(getSavedEmployee()).lastName(newName).firstName("Newname").build();
        System.out.println("In update, about_to_update = " + employee);
        Employee update = this.repository.update(employee);
        Assert.assertSame(newName, update.getLastName());
        Assert.assertSame("Newname", update.getFirstName());
    }

    @Test
    public void d_getAll(){
        Set<Employee> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void e_delete(){
        Employee saved = getSavedEmployee();
        this.repository.delete(saved.getEmployeeId());
        d_getAll();
    }


}
