package com.photonumber.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by michal on 21/11/2016.
 */
@Entity
public class Zawody {

    @Id
    private String id;
    private String nazwa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
