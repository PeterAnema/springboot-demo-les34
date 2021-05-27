package com.example.demo.service;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Persoon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersoonServiceImpl implements PersoonService {

    private List<Persoon> personen = new ArrayList<>();

    @Override
    public List<Persoon> getPersonen() {
        return personen;
    }

    @Override
    public Persoon getPersoon(long id) {
        Persoon persoon = null;
        for (int i=0; i<personen.size(); i++) {
            if (id == personen.get(i).getId()) {
                persoon = personen.get(i);
            }
        }
        if (persoon == null) {
            throw new RecordNotFoundException("id bestaat niet");
        }
        return persoon;
    }

    @Override
    public Persoon addPersoon(Persoon persoon) {
        personen.add(persoon);
        return persoon;
    }

    @Override
    public void removePersoon(long id) {
        Persoon persoon = null;
        for (int i=0; i<personen.size(); i++) {
            if (id == personen.get(i).getId()) {
                personen.remove(i);
            }
        }
        if (persoon == null) {
            throw new RecordNotFoundException("id bestaat niet");
        }
    }

    @Override
    public void updatePersoon(long id, Persoon nieuwPersoon) {
        Persoon persoon = null;
        for (int i=0; i<personen.size(); i++) {
            if (id == personen.get(i).getId()) {
                persoon = personen.get(i);
            }
        }
        if (persoon == null) {
            throw new RecordNotFoundException("id bestaat niet");
        }
        else {
            persoon.setVoornaam(nieuwPersoon.getVoornaam());
            persoon.setAchternaam(nieuwPersoon.getAchternaam());
            persoon.setWoonplaats(nieuwPersoon.getWoonplaats());
            persoon.setEmailAdres(nieuwPersoon.getEmailAdres());
            persoon.setLeeftijd(nieuwPersoon.getLeeftijd());
        }

    }

}
