package cput.ac.za.factory.demographic;

import cput.ac.za.domain.demographic.Race;
import cput.ac.za.util.Misc;

public class RaceFactory {
    public static Race buildRace(String race){
        return new Race.Builder().raceId(Misc.generateId())
                .race(race)
                .build();
    }
}
