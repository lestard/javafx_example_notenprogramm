package de.hszg.notenprogramm.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lehrplan extends Identity{

    private List<Fach> faecher = new ArrayList<>();

    public void addFach(Fach fach) {
        faecher.add(fach);
    }

    public List<Fach> getFaecher() {
        return Collections.unmodifiableList(faecher);
    }

    public boolean isFachTitelBelegt(String titel) {
        return faecher.stream().filter(f -> f.getTitel().equals(titel)).findAny().isPresent();
    }

}
