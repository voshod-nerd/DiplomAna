/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Stoimostuslug;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface StoimostUslugRepository {
    List<Stoimostuslug> findAll();

    Stoimostuslug update(Stoimostuslug rab);

    Stoimostuslug create(Stoimostuslug rab);

    List<Stoimostuslug> findAllWithDetails();

    Stoimostuslug save(Stoimostuslug rab);

    void delete(Stoimostuslug rab); 
}
