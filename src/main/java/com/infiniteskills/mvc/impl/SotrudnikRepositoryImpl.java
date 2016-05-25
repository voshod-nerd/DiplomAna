/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.repository.SotrudnikRepository;
import com.infiniteskills.mvc.entity.Sotrudnik;
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

@Service("jpaSotrudnikService")
@Transactional
@Repository
public class SotrudnikRepositoryImpl implements SotrudnikRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Sotrudnik> findAll() {
      return em.createNamedQuery("Sotrudnik.findAll").getResultList();
    }

    public List<Sotrudnik> findAllWithDetails() {
        return em.createNamedQuery("Sotrudnik.findAllWithDetail").getResultList();
    }

    public Sotrudnik save(Sotrudnik nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Sotrudnik nomer) {
          Sotrudnik mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
     public Sotrudnik create(Sotrudnik zav) {
         em.persist(zav);
        return zav;
    }

    public Sotrudnik update(Sotrudnik zav) {
      
        return em.merge(zav);
    }
    
}
