/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Pitanie;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface PitanieRepository {

    List<Pitanie> findAll();

    Pitanie update(Pitanie pit);

    Pitanie create(Pitanie pit);

    List<Pitanie> findAllWithDetails();

    Pitanie save(Pitanie pit);

    void delete(Pitanie pit);
}
