/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Grafik;
import com.infiniteskills.mvc.repository.GrafikRepository;
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

@Service("jpaGrafikRepository")
@Transactional
@Repository
public class GrafikRepositoryImpl implements GrafikRepository {
     @PersistenceContext
    private EntityManager em;
    public List<Grafik> findAll() {
       return em.createNamedQuery("Grafik.findAll").getResultList();
    }

     public List<Grafik> findAllWithDetails() {
        return em.createNamedQuery("Grafik.findAllWithDetail").getResultList();
    }

    public Grafik save(Grafik nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Grafik nomer) {
          Grafik mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    public Grafik update(Grafik hot) {
         return em.merge(hot);
    }

    public Grafik create(Grafik hot) {
       em.persist(hot);
        return hot;
    }
}
