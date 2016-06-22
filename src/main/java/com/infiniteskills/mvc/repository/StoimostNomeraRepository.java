/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Stoimostnomera;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface StoimostNomeraRepository {
    List<Stoimostnomera> findAll();

    Stoimostnomera update(Stoimostnomera rab);

    Stoimostnomera create(Stoimostnomera rab);

    List<Stoimostnomera> findAllWithDetails();

    Stoimostnomera save(Stoimostnomera rab);

    void delete(Stoimostnomera rab); 
    public Stoimostnomera getSumForBronUser(String usr,int typenomer);
    Stoimostnomera getStoimNomerByNomerAndTarif(int tarif,int typenomer);
}
