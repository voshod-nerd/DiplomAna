/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Dolgnost;
import com.infiniteskills.mvc.repository.DolgnostRepository;
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

@Service("jpaDolgnostService")
@Transactional
@Repository
public class DolgnostRepositoryImpl implements DolgnostRepository {
     @PersistenceContext
    private EntityManager em;
     
    @Override 
    public List<Dolgnost> findAll() {
       return em.createNamedQuery("Dolgnost.findAll").getResultList();
    }

    @Override
     public List<Dolgnost> findAllWithDetails() {
        return em.createNamedQuery("Dolgnost.findAllWithDetail").getResultList();
    }

     
     @Override
    public Dolgnost save(Dolgnost nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    
    @Override
    public void delete(Dolgnost nomer) {
          Dolgnost mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    
    @Override
    public Dolgnost update(Dolgnost hot) {
         return em.merge(hot);
    }

    @Override
    public Dolgnost create(Dolgnost hot) {
       em.persist(hot);
        return hot;
    }
    
}
