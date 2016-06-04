/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Grafik;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface GrafikRepository {
      List<Grafik> findAll();
     Grafik update(Grafik pit);
     Grafik create(Grafik pit);
     List<Grafik> findAllWithDetails();
     Grafik save(Grafik pit);
     void delete(Grafik pit);
}
