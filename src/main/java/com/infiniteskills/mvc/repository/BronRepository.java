/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Bron;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface BronRepository {
     List<Bron> findAll();

    Bron update(Bron prog);

    Bron create(Bron prog);

    List<Bron> findAllWithDetails();

    Bron save(Bron prog);

    void delete(Bron prog);
}
