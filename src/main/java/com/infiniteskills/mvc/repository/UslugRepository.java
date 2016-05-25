/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Uslug;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface UslugRepository {
     List<Uslug> findAll();

    Uslug update(Uslug rab);

    Uslug create(Uslug rab);

    List<Uslug> findAllWithDetails();

    Uslug save(Uslug rab);

    void delete(Uslug rab);
}
