/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.entity.Tarifz;
import com.infiniteskills.mvc.repository.TarifzRepository;
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
@Service("jpaTarifzService")
@Transactional
@Repository
public class TarifzRepositoryImpl implements TarifzRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Tarifz> findAll() {
      return em.createNamedQuery("Tarifz.findAll").getResultList();
    }

    public List<Tarifz> findAllWithDetails() {
        return em.createNamedQuery("Tarifz.findAllWithDetail").getResultList();
    }

    public Tarifz save(Tarifz nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }
   
     @Override
    public Tarifz getTarifByClient(Client cl) {
       String sql = "  SELECT * from tarifz t WHERE t.id IN \n" +
"(SELECT p.idtarif from program p WHERE p.idorganization IN (\n" +
"SELECT id  FROM ORGANIZATION o WHERE ID IN (\n" +
"(SELECT idorg FROM client WHERE ID=?1))))";
        Query query = em.createNativeQuery(sql, Tarifz.class);
        query.setParameter(1, cl.getId());
        try {
            return (Tarifz) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    } 
    
    
    
    public void delete(Tarifz nomer) {
          Tarifz mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Tarifz create(Tarifz zav) {
         em.persist(zav);
        return zav;
    }

    public Tarifz update(Tarifz zav) {
       
        return em.merge(zav);
    }
    
    public Tarifz find(Tarifz zav) {
        return em.find(Tarifz.class, zav.getId());
    }
}
