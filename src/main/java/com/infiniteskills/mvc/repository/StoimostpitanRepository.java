/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Stimostpitan;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface StoimostpitanRepository {
    List<Stimostpitan> findAll();

    Stimostpitan update(Stimostpitan rab);

    Stimostpitan create(Stimostpitan rab);

    List<Stimostpitan> findAllWithDetails();

    Stimostpitan save(Stimostpitan rab);

    void delete(Stimostpitan rab);
}
