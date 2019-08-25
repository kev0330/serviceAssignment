package cput.ac.za.factory.people;

import cput.ac.za.domain.people.Employee;
import cput.ac.za.util.Misc;

public class EmployeeFactory {

    public static Employee buildEmployee(String firstName,String lastName, int age){
        return new Employee.Builder().firstName(firstName)
                .lastName(lastName)
                .employeeId(Misc.generateId())
                .empAge(age)
                .build();
    }
}
