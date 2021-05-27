package com.example.demo.service;

import com.example.demo.model.Persoon;

import java.util.List;

public interface PersoonService {

    List<Persoon> getPersonen();
    Persoon getPersoon(long id);
    Persoon addPersoon(Persoon persoon);
    void removePersoon(long id);
    void updatePersoon(long id, Persoon persoon);

}
