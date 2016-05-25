/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.repository.BronRepository;
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
@Service("jpaBronService")
@Transactional
@Repository
public class BronRepositoryImpl implements BronRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Bron> findAll() {
      return em.createNamedQuery("Bron.findAll").getResultList();
    }

    public List<Bron> findAllWithDetails() {
        return em.createNamedQuery("Bron.findAllWithDetail").getResultList();
    }

    public Bron save(Bron nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Bron nomer) {
          Bron mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Bron create(Bron zav) {
         em.persist(zav);
        return zav;
    }

    public Bron update(Bron zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Bron find(Bron zav) {
        return em.find(Bron.class, zav.getId());
    }
}
