/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.entity.Reestruslug;
import com.infiniteskills.mvc.repository.ReestrUslugRepository;
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
@Service("jpaReestrUslugService")
@Transactional
@Repository
public class ReestruslugRepositoryImpl implements ReestrUslugRepository {
     @PersistenceContext
    private EntityManager em;
    
    public List<Reestruslug> findAll() {
      return em.createNamedQuery("Reestruslug.findAll").getResultList();
    }

    public List<Reestruslug> findAllWithDetails() {
        return em.createNamedQuery("Reestruslug.findAllWithDetail").getResultList();
    }

    public Reestruslug save(Reestruslug nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }
   
      @Override
    public List<Reestruslug> getListUslugByIdClient(Client cl) {
       String sql = "SELECT * FROM reestruslug r WHERE r.idclient=?1";
       
        Query query = em.createNativeQuery(sql, Reestruslug.class);
          query.setParameter(1, cl.getId());
        try {
            return (List<Reestruslug>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    public void delete(Reestruslug nomer) {
          Reestruslug mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Reestruslug create(Reestruslug zav) {
         em.persist(zav);
        return zav;
    }

    public Reestruslug update(Reestruslug zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Reestruslug find(Reestruslug zav) {
        return em.find(Reestruslug.class, zav.getId());
    }
}
