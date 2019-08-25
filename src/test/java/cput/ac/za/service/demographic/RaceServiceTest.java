package cput.ac.za.service.demographic;

import cput.ac.za.domain.demographic.Race;
import cput.ac.za.factory.demographic.RaceFactory;
import cput.ac.za.service.demographic.Impl.RaceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RaceServiceTest {

    private RaceServiceImpl service;
    private Race employee;

    private Race getSaved(){
        return this.service.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = RaceServiceImpl.getService();
        this.employee = RaceFactory.buildRace("African");
    }

    @Test
    public void a_create(){
        Race employee = this.service.create(this.employee);
        System.out.println("In create, create =" + employee);
        Assert.assertNotNull(employee);
        Assert.assertSame(employee,this.employee);
    }

    @Test
    public void b_read(){
        Race saved = getSaved();
        Race read = this.service.read(saved.getRaceId());
        System.out.println("In read, read = " + read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void c_update(){
        String newName = "Asian";
        Race update = new Race.Builder().copy(getSaved()).race(newName).build();
        System.out.println("In update, updated = " + update);
        this.service.update(update);
        Assert.assertSame(newName, update.getRace());
    }

    @Test
    public void d_getAll(){
        Set<Race> all = this.service.getAll();
        System.out.println("In getAll, all = " + all);
    }

    @Test
    public void e_delete(){
        Race saved = getSaved();
        this.service.delete(saved.getRace());
        d_getAll();
    }
}
