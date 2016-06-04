/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Typeza;
import java.util.List;

/**
 *
 * @author Соколов
 */
public interface TypeZayavkaRepository {

    List<Typeza> findAll();

    List<Typeza> findAllWithDetails();

    Typeza save(Typeza post);

    void delete(Typeza post);
    
    Typeza update(Typeza rab);

    Typeza create(Typeza rab);
}
