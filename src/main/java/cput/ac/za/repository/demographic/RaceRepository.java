package cput.ac.za.repository.demographic;

import cput.ac.za.domain.demographic.Race;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface RaceRepository extends IRepository<Race,String> {
    Set<Race> getAll();
}
