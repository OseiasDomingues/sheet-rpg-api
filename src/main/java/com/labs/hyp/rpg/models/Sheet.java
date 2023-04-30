package com.labs.hyp.rpg.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Sheet extends PanacheEntity {

    public String name;
    public Long level;
    public Long pv;
    public Long defense;
    @OneToOne(cascade = CascadeType.ALL)
    public Attributes attributes;
}
