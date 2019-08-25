package cput.ac.za.service.demographic.Impl;

import cput.ac.za.domain.demographic.Race;
import cput.ac.za.repository.demographic.RaceRepository;
import cput.ac.za.repository.demographic.impl.RaceRepositoryImpl;
import cput.ac.za.service.demographic.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("ServiceImpl")
public class RaceServiceImpl implements RaceService {

    @Autowired
    @Qualifier("InMemory")
    private static RaceServiceImpl service = null;
    private RaceRepository employees;

    private RaceServiceImpl(){
        this.employees = RaceRepositoryImpl.getRepository();
    }

    public static RaceServiceImpl getService(){
        if(service == null) service = new RaceServiceImpl();
        return service;
    }

    public Race create(Race employee){
        return this.employees.create(employee);
    }

    public Race update(Race emp){
        return this.employees.update(emp);
    }

    public void delete(String emp){
        this.employees.delete(emp);
    }

    public Race read(String emp){
        return this.employees.read(emp);
    }

    public Set<Race> getAll(){
        return this.employees.getAll();
    }
}
