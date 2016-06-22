/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Viza;
import com.infiniteskills.mvc.repository.VizaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Юыху
 */

@Service("jpaVizaService")
@Transactional
@Repository
public class VizaRepositoryImpl implements VizaRepository {
     @PersistenceContext
    private EntityManager em;
    
     @Override
    public List<Viza> findAll() {
      return em.createNamedQuery("Viza.findAll").getResultList();
    }
    
    @Override
    public List<Viza> findAllWithDetails() {
        return em.createNamedQuery("Viza.findAllWithDetail").getResultList();
    }

    @Override
    public Viza save(Viza nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    @Override
    public void delete(Viza nomer) {
          Viza mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    @Override
    public Viza create(Viza zav) {
         em.persist(zav);
        return zav;
    }

    @Override
    public Viza update(Viza zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Viza find(Viza zav) {
        return em.find(Viza.class, zav.getId());
    }
}
