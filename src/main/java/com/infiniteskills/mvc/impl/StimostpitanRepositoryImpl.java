/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Stimostpitan;
import com.infiniteskills.mvc.repository.StoimostpitanRepository;
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
@Service("jpaStoimPitService")
@Transactional
@Repository
public class StimostpitanRepositoryImpl implements StoimostpitanRepository {
     @PersistenceContext
    private EntityManager em;
    
    public List<Stimostpitan> findAll() {
      return em.createNamedQuery("Stimostpitan.findAll").getResultList();
    }

    public List<Stimostpitan> findAllWithDetails() {
        return em.createNamedQuery("Stimostpitan.findAllWithDetail").getResultList();
    }

    public Stimostpitan save(Stimostpitan nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Stimostpitan nomer) {
          Stimostpitan mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Stimostpitan create(Stimostpitan zav) {
         em.persist(zav);
        return zav;
    }

    public Stimostpitan update(Stimostpitan zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Stimostpitan find(Stimostpitan zav) {
        return em.find(Stimostpitan.class, zav.getId());
    }
}
