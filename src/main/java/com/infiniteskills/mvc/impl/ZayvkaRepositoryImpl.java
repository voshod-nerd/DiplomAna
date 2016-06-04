/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.repository.ZayavkaRepository;
import com.infiniteskills.mvc.entity.Zayvka;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Соколов
 */

@Service("jpaZayvkaService")
@Transactional
@Repository
public class ZayvkaRepositoryImpl implements ZayavkaRepository {

    @PersistenceContext
    private EntityManager em;
    
    public List<Zayvka> findAll() {
      return em.createNamedQuery("Zayvka.findAll").getResultList();
    }

    public List<Zayvka> findAllWithDetails() {
        return em.createNamedQuery("Zayvka.findAllWithDetail").getResultList();
    }

    public Zayvka save(Zayvka nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Zayvka nomer) {
          Zayvka mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Zayvka create(Zayvka zav) {
         em.persist(zav);
        return zav;
    }

    public Zayvka update(Zayvka zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Zayvka find(Zayvka zav) {
        return em.find(Zayvka.class, zav.getId());
    }
    
}
