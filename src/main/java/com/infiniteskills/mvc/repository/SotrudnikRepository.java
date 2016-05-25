/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Sotrudnik;
import java.util.List;

/**
 *
 * @author Соколов
 */
public interface SotrudnikRepository {
     List<Sotrudnik> findAll();

    List<Sotrudnik> findAllWithDetails();

    Sotrudnik save(Sotrudnik post);

    void delete(Sotrudnik post);
    Sotrudnik update(Sotrudnik rab);

    Sotrudnik create(Sotrudnik rab);
}
