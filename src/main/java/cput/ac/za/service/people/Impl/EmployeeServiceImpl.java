package cput.ac.za.service.people.Impl;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.repository.people.EmployeeRepository;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import cput.ac.za.service.people.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("ServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    @Qualifier("InMemory")
    private static EmployeeServiceImpl service = null;
    private EmployeeRepository repository;


    private EmployeeServiceImpl(){
        this.repository = EmployeeRepositoryImpl.getRepository();
    }

    public static EmployeeServiceImpl getService(){
        if(service == null) service = new EmployeeServiceImpl();
        return service;
    }

    public Employee create(Employee employee){
        return this.repository.create(employee);
    }

    public Employee update(Employee emp){
        return this.repository.update(emp);
    }

    public void delete(String emp){
        this.repository.delete(emp);
    }

    public Employee read(String emp){
        return this.repository.read(emp);
    }

    public Set<Employee> getAll(){
        return this.repository.getAll();
    }
}

