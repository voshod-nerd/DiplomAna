/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Otpusk;
import com.infiniteskills.mvc.repository.OtpuskRepository;
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
@Service("jpaOtpuskRepository")
@Transactional
@Repository
public class OtpuskRepositoryImpl implements OtpuskRepository {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Otpusk> findAll() {
       return em.createNamedQuery("Otpusk.findAll").getResultList();
    }

    
    @Override
     public List<Otpusk> findAllWithDetails() {
        return em.createNamedQuery("Otpusk.findAllWithDetail").getResultList();
    }
   
     
    @Override 
    public Otpusk save(Otpusk nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    @Override
    public void delete(Otpusk nomer) {
          Otpusk mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    
    @Override
    public Otpusk update(Otpusk hot) {
         return em.merge(hot);
    }

    
    @Override
    public Otpusk create(Otpusk hot) {
       em.persist(hot);
        return hot;
    }
    
      @Override
    public List<Otpusk> getOtpuskByIdsotr(String cl) {
       String sql = "SELECT * FROM otpusk r WHERE r.idsotr=?1";
       
        Query query = em.createNativeQuery(sql, Otpusk.class);
          query.setParameter(1, cl);
        try {
            return (List<Otpusk>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    @Override
    public Otpusk getOtpuskById(String id) {
       String sql = "SELECT * FROM otpusk r WHERE r.id=?1";
       
        Query query = em.createNativeQuery(sql, Otpusk.class);
          query.setParameter(1, id);
        try {
            return (Otpusk) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
}
