/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.entity.Tarifz;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface TarifzRepository {
     List<Tarifz> findAll();

    Tarifz update(Tarifz rab);

    Tarifz create(Tarifz rab);

    List<Tarifz> findAllWithDetails();

    Tarifz save(Tarifz rab);

    void delete(Tarifz rab);
    
    Tarifz getTarifByClient(Client cl);
}
