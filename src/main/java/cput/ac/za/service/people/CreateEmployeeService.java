package cput.ac.za.service.people;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.domain.demographic.Race;
import cput.ac.za.domain.people.Employee;

public interface CreateEmployeeService {

    Employee saveEmp(String id, String firstName, String lastName, int age, String Gender, String race);

        Gender getGender(String id);

        Race getRace(String id);
}
