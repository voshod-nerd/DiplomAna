/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Pitanie;
import com.infiniteskills.mvc.repository.PitanieRepository;
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
@Service("jpaPitService")
@Transactional
@Repository
public class PitanieRepositoryImpl implements PitanieRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Pitanie> findAll() {
      return em.createNamedQuery("Pitanie.findAll").getResultList();
    }

    public List<Pitanie> findAllWithDetails() {
        return em.createNamedQuery("Pitanie.findAllWithDetail").getResultList();
    }

    public Pitanie save(Pitanie nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Pitanie nomer) {
          Pitanie mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Pitanie create(Pitanie zav) {
         em.persist(zav);
        return zav;
    }

    public Pitanie update(Pitanie zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Pitanie find(Pitanie zav) {
        return em.find(Pitanie.class, zav.getId());
    }
}
