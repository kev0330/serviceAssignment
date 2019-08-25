package cput.ac.za.repository.demographic;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface GenderRepository extends IRepository<Gender,String> {
    Set<Gender> getAll();
}
