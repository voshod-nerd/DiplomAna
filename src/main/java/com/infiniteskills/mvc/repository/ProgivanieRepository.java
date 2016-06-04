/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Progivanie;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface ProgivanieRepository {
     List<Progivanie> findAll();

    Progivanie update(Progivanie prog);

    Progivanie create(Progivanie prog);

    List<Progivanie> findAllWithDetails();

    Progivanie save(Progivanie prog);

    void delete(Progivanie prog);
}
