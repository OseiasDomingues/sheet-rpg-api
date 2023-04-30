package com.labs.hyp.rpg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Attributes extends PanacheEntity {

    public Long force;
    public Long dexterity;
    public Long constitution;
    public Long intelligence;
    public Long wisdom;
    public Long charisma;

    @JsonIgnore
    @OneToOne(mappedBy = "attributes")
    public Sheet sheet;
}
