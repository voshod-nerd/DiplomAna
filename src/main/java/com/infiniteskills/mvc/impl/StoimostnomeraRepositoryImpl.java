/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Stoimostnomera;
import com.infiniteskills.mvc.repository.StoimostNomeraRepository;
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
@Service("jpaStoimNomerService")
@Transactional
@Repository
public class StoimostnomeraRepositoryImpl implements StoimostNomeraRepository  {
     @PersistenceContext
    private EntityManager em;
    @Override
    public List<Stoimostnomera> findAll() {
      return em.createNamedQuery("Stoimostnomera.findAll").getResultList();
    }
    
    @Override
    public List<Stoimostnomera> findAllWithDetails() {
        return em.createNamedQuery("Stoimostnomera.findAllWithDetail").getResultList();
    }

    public Stoimostnomera save(Stoimostnomera nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Stoimostnomera nomer) {
          Stoimostnomera mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Stoimostnomera create(Stoimostnomera zav) {
         em.persist(zav);
        return zav;
    }

    public Stoimostnomera update(Stoimostnomera zav) {
      
        return em.merge(zav);
    }
    
    public Stoimostnomera find(Stoimostnomera zav) {
        return em.find(Stoimostnomera.class, zav.getId());
    }
}
