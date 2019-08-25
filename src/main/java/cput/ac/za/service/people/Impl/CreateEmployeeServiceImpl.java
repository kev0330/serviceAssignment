package cput.ac.za.service.people.Impl;

import com.sun.org.glassfish.gmbal.ManagedObject;
import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.domain.demographic.Race;
import cput.ac.za.domain.people.Employee;
import cput.ac.za.factory.demographic.GenderFactory;
import cput.ac.za.factory.demographic.RaceFactory;
import cput.ac.za.factory.people.EmployeeFactory;
import cput.ac.za.repository.demographic.impl.GenderRepositoryImpl;
import cput.ac.za.repository.demographic.impl.RaceRepositoryImpl;
import cput.ac.za.repository.people.impl.EmployeeRepositoryImpl;
import cput.ac.za.service.people.CreateEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateEmployeeServiceImpl implements CreateEmployeeService {

    @Autowired
    public EmployeeRepositoryImpl empRepository = EmployeeRepositoryImpl.getRepository();
    @Autowired
    public GenderRepositoryImpl genderRepository = GenderRepositoryImpl.getGenderRepositoryImpl();
    @Autowired
    public RaceRepositoryImpl raceRepository = RaceRepositoryImpl.getRepository();
    @Autowired
    public EmployeeFactory employeeFactory;
    @Autowired
    public GenderFactory genderFactory;
    @Autowired
    public RaceFactory raceFactory;

    public CreateEmployeeServiceImpl(){

    }

    @Override
    public Employee saveEmp(String id, String empName, String empSurname, int age, String empGender, String empRace){
        Employee emp = this.empRepository.create(EmployeeFactory.buildEmployee(empName,empSurname,age));
        Gender gender = this.genderRepository.create(GenderFactory.buildGender(empGender));
        Race race = this.raceRepository.create(RaceFactory.buildRace(empRace));
        return emp;
    }

    @Override
    public Gender getGender(String gender){
        return this.genderRepository.read(gender);
    }

    @Override
    public Race getRace(String race){
        return this.raceRepository.read(race);
    }
}
