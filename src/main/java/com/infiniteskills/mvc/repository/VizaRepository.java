/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Viza;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface VizaRepository {
     List<Viza> findAll();

    Viza update(Viza rab);

    Viza create(Viza rab);

    List<Viza> findAllWithDetails();

    Viza save(Viza rab);

    void delete(Viza rab);
}
