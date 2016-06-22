/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Nomerhotel;
import com.infiniteskills.mvc.entity.Typenomerhotel;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface TypeNomerHotelRepository {
    List<Typenomerhotel> findAll();

    Typenomerhotel update(Typenomerhotel rab);

    Typenomerhotel create(Typenomerhotel rab);

    List<Typenomerhotel> findAllWithDetails();

    Typenomerhotel save(Typenomerhotel rab);

    void delete(Typenomerhotel rab); 
    Typenomerhotel getTypeNomerByIdnomer(Nomerhotel nomer);
}
