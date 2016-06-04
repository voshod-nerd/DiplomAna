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
import javax.persistence.PersistenceContext;
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
    public List<Otpusk> findAll() {
       return em.createNamedQuery("Otpusk.findAll").getResultList();
    }

     public List<Otpusk> findAllWithDetails() {
        return em.createNamedQuery("Otpusk.findAllWithDetail").getResultList();
    }

    public Otpusk save(Otpusk nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Otpusk nomer) {
          Otpusk mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    public Otpusk update(Otpusk hot) {
         return em.merge(hot);
    }

    public Otpusk create(Otpusk hot) {
       em.persist(hot);
        return hot;
    }
}
