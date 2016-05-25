/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Hotel;
import java.util.List;

/**
 *
 * @author Соколов
 */
public interface HotelRepository {

    List<Hotel> findAll();

    Hotel update(Hotel hot);

    Hotel create(Hotel hot);

    List<Hotel> findAllWithDetails();

    Hotel save(Hotel hot);

    void delete(Hotel hot);
}
