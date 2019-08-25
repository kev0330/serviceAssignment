package cput.ac.za.service.demographic;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.service.IService;

import java.util.Set;

public interface GenderService extends IService<Gender,String> {
    Set<Gender> getAll();
}
