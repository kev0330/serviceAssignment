package cput.ac.za.service.demographic;

import cput.ac.za.domain.demographic.Race;
import cput.ac.za.service.IService;

import java.util.Set;

public interface RaceService extends IService<Race,String> {
    Set<Race> getAll();
}
