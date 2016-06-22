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
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
     @Override
    public List<Sotrudnik> findAll() {
      return em.createNamedQuery("Sotrudnik.findAll").getResultList();
    }

     @Override
    public List<Sotrudnik> findAllWithDetails() {
        return em.createNamedQuery("Sotrudnik.findAllWithDetail").getResultList();
    }

     @Override
    public Sotrudnik save(Sotrudnik nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

     @Override
    public void delete(Sotrudnik nomer) {
          Sotrudnik mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
     @Override
     public Sotrudnik create(Sotrudnik zav) {
         em.persist(zav);
        return zav;
    }
    
     @Override
    public Sotrudnik update(Sotrudnik zav) {     
        return em.merge(zav);
    }
    
    @Override
    public Sotrudnik getSotrudnikById(String idsotr) {
       String sql = "SELECT * FROM sotrudnik r WHERE r.id=?1";
        Query query = em.createNativeQuery(sql, Sotrudnik.class);
          query.setParameter(1, idsotr);
        try {
            return (Sotrudnik) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
}
