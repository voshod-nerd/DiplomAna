/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Reestruslug;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface ReestrUslugRepository {
     List<Reestruslug> findAll();

    Reestruslug update(Reestruslug rab);

    Reestruslug create(Reestruslug rab);

    List<Reestruslug> findAllWithDetails();

    Reestruslug save(Reestruslug rab);

    void delete(Reestruslug rab);
}
