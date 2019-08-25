package cput.ac.za.factory.demographic;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.util.Misc;

public class GenderFactory {
    public static Gender buildGender(String gender){
        return new Gender.Builder().genderId(Misc.generateId())
                .genderName(gender)
                .build();
    }
}
