package cput.ac.za.repository.demographic.impl;

import cput.ac.za.domain.demographic.Race;
import cput.ac.za.repository.demographic.RaceRepository;

import java.util.HashSet;
import java.util.Set;

public class RaceRepositoryImpl implements RaceRepository {

    private static RaceRepositoryImpl repository = null;
    private Set<Race> races;

    private RaceRepositoryImpl(){
        this.races = new HashSet<>();
    }

    private Race find(String raceId) {
        return this.races.stream()
                .filter(id -> id.getRaceId().equals(raceId))
                .findAny()
                .orElse(null);
    }

    public static RaceRepositoryImpl getRepository(){
        if(repository == null) repository = new RaceRepositoryImpl();
        return repository;
    }

    public Race create(Race race){
        this.races.add(race);
        return race;
    }

    public Race read(final String raceId){
        Race race = find(raceId);
        return race;
    }

    public void delete(String raceId) {
        Race race = find(raceId);
        if(race != null) this.races.remove(race);
    }

    public Race update(Race race) {
        Race delete = find(race.getRaceId());
        if(delete != null){
            this.races.remove(delete);
            return create(race);
        }
        return null;
    }

    public Set<Race> getAll(){
        return this.races;
    }
}
