/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Uslug;
import com.infiniteskills.mvc.repository.UslugRepository;
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
@Service("jpaUslugService")
@Transactional
@Repository
public class UslugRepositoryImpl implements UslugRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Uslug> findAll() {
      return em.createNamedQuery("Uslug.findAll").getResultList();
    }

    public List<Uslug> findAllWithDetails() {
        return em.createNamedQuery("Uslug.findAllWithDetail").getResultList();
    }

    public Uslug save(Uslug nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Uslug nomer) {
          Uslug mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Uslug create(Uslug zav) {
         em.persist(zav);
        return zav;
    }

    public Uslug update(Uslug zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Uslug find(Uslug zav) {
        return em.find(Uslug.class, zav.getId());
    }
}
