/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Zayvka;
import java.util.List;

/**
 *
 * @author Соколов
 */
public interface ZayavkaRepository {

    List<Zayvka> findAll();

    Zayvka update(Zayvka zav);

    Zayvka create(Zayvka zav);

    List<Zayvka> findAllWithDetails();

    Zayvka save(Zayvka nomer);

    void delete(Zayvka nomer);
}
