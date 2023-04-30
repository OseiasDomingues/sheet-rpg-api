package com.labs.hyp.rpg.services;


import com.labs.hyp.rpg.models.Sheet;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public interface SheetServices {

    List<Sheet> getAll();
    Sheet get(Long id);
    void insert(Sheet sheet);
    void update(Sheet sheet);
    void delete(Long id);

}
