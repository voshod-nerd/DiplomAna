/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.repository.ProgivanieRepository;
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
@Service("jpaProgService")
@Transactional
@Repository
public class ProgivanieRepositoryImpl implements ProgivanieRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Progivanie> findAll() {
      return em.createNamedQuery("Progivanie.findAll").getResultList();
    }

    public List<Progivanie> findAllWithDetails() {
        return em.createNamedQuery("Progivanie.findAllWithDetail").getResultList();
    }

    public Progivanie save(Progivanie nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Progivanie nomer) {
         Progivanie mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Progivanie create(Progivanie zav) {
         em.persist(zav);
        return zav;
    }

    public Progivanie update(Progivanie zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Progivanie find(Progivanie zav) {
        return em.find(Progivanie.class, zav.getId());
    }
}
