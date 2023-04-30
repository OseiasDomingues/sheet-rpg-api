package com.labs.hyp.rpg.services.impl;

import com.labs.hyp.rpg.models.Attributes;
import com.labs.hyp.rpg.models.Sheet;
import com.labs.hyp.rpg.services.SheetServices;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SheetServicesImpl implements SheetServices {
    @Override
    public List<Sheet> getAll() {
        return PanacheEntityBase.listAll();
    }

    @Override
    public Sheet get(Long id) {
        return PanacheEntityBase.findById(id);
    }

    @Override
    public void insert(Sheet sheet) {
        PanacheEntityBase.persist(sheet);
    }

    @Override
    public void update(Sheet sheet) {
        Sheet sheetDatabase = PanacheEntityBase.findById(sheet.id);
        if(sheetDatabase.isPersistent()){
            sheetDatabase.name = sheet.name;
            sheetDatabase.level = sheet.level;
            sheetDatabase.pv = sheet.pv;
            sheetDatabase.defense = sheet.defense;
            updateAttributes(sheetDatabase.attributes,sheet.attributes);
            PanacheEntityBase.persist(sheet);
        }
    }

    @Override
    public void delete(Long id) {
        PanacheEntityBase.deleteById(id);
    }

    private void updateAttributes(Attributes attributesDatabase, Attributes attributes) {
        attributesDatabase.charisma = attributes.charisma;
        attributesDatabase.force = attributes.force;
        attributesDatabase.wisdom = attributes.wisdom;
        attributesDatabase.intelligence = attributes.intelligence;
        attributesDatabase.constitution = attributes.constitution;
        attributesDatabase.dexterity = attributes.dexterity;
    }

}
