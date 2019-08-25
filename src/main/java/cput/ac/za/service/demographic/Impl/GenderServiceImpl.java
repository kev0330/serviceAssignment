package cput.ac.za.service.demographic.Impl;

import cput.ac.za.domain.demographic.Gender;
import cput.ac.za.repository.demographic.GenderRepository;
import cput.ac.za.repository.demographic.impl.GenderRepositoryImpl;
import cput.ac.za.service.demographic.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("ServiceImpl")
public class GenderServiceImpl implements GenderService {

    @Autowired
    @Qualifier("InMemory")
    private static GenderServiceImpl service = null;
    private GenderRepository repository;

    private GenderServiceImpl() {
        this.repository = GenderRepositoryImpl.getGenderRepositoryImpl();
    }

    public static GenderServiceImpl getService(){
        if (service == null) service = new GenderServiceImpl();
        return service;
    }

    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }



    @Override
    public Set<Gender> getAll() {
        return this.repository.getAll();
    }
}
