/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Grafik;
import com.infiniteskills.mvc.repository.GrafikRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
     
     @Override
    public List<Grafik> findAll() {
       return em.createNamedQuery("Grafik.findAll").getResultList();
    }
    
    @Override
     public List<Grafik> findAllWithDetails() {
        return em.createNamedQuery("Grafik.findAllWithDetail").getResultList();
    }

     
    @Override 
    public Grafik save(Grafik nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }
    
    @Override
    public void delete(Grafik nomer) {
          Grafik mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    @Override
    public Grafik update(Grafik hot) {
         return em.merge(hot);
    }
    
    @Override
    public Grafik create(Grafik hot) {
       em.persist(hot);
        return hot;
    }
    
       @Override
    public List<Grafik> getGrafikByHotel(Date begin,Date end) {
       String sql = "SELECT * FROM grafik g WHERE g.dayd>=?1 and g.dayd<=?2";
        Query query = em.createNativeQuery(sql, Grafik.class);
        query.setParameter(1, begin);
         query.setParameter(2, end);
        
        try {
            return (List<Grafik>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
}
