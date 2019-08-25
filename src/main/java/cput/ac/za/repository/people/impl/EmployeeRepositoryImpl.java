package cput.ac.za.repository.people.impl;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.repository.people.EmployeeRepository;

import java.util.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepositoryImpl repository = null;
    private Set<Employee> employees;

    private EmployeeRepositoryImpl(){
        this.employees = new HashSet<>();
    }

    private Employee find(String employee) {
        return this.employees.stream()
                .filter(id -> id.getEmployeeId().equals(employee))
                .findAny()
                .orElse(null);
    }

    public static EmployeeRepositoryImpl getRepository(){
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    public Employee create(Employee employee){
        this.employees.add(employee);
        return employee;
    }

    public Employee read(final String employees){
        Employee employee = find(employees);
        return employee;
    }

    public void delete(String employees) {
        Employee employee = find(employees);
        if(employee != null) this.employees.remove(employee);
    }

    public Employee update(Employee employee) {
        Employee delete = find(employee.getEmployeeId());
        if(delete != null){
            this.employees.remove(delete);
            return create(employee);
        }
        return null;
    }

    public Set<Employee> getAll(){
        return this.employees;
    }
}
