/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.repository.ZayavkaRepository;
import com.infiniteskills.mvc.entity.Zayvka;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Соколов
 */

@Service("jpaZayvkaService")
@Transactional
@Repository
public class ZayvkaRepositoryImpl implements ZayavkaRepository {

    @PersistenceContext
    private EntityManager em;
    
    public List<Zayvka> findAll() {
      return em.createNamedQuery("Zayvka.findAll").getResultList();
    }

    public List<Zayvka> findAllWithDetails() {
        return em.createNamedQuery("Zayvka.findAllWithDetail").getResultList();
    }

    public Zayvka save(Zayvka nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Zayvka nomer) {
          Zayvka mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Zayvka create(Zayvka zav) {
         em.persist(zav);
        return zav;
    }

    public Zayvka update(Zayvka zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Zayvka find(Zayvka zav) {
        return em.find(Zayvka.class, zav.getId());
    }
    
    
   @Override
    public List<Zayvka> getByHotel(int hotel) {
       
        String sql = "SELECT * FROM ZAYVKA z WHERE z.IDNOMER IN (SELECT ID FROM NOMERHOTEL n WHERE n.IDGOSTIN=?1)";
        Query query = em.createNativeQuery(sql, Zayvka.class);
        query.setParameter(1, hotel);
       
        try {
            return (List<Zayvka>) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }
    
    
    @Override
    public List<Zayvka> getAllCurrentZyavka() {
       
        String sql = "SELECT * FROM ZAYVKA z WHERE z.status=?1";
        Query query = em.createNativeQuery(sql, Zayvka.class);
        query.setParameter(1, "в процессе");
       
        try {
            return (List<Zayvka>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }
    
    @Override
    public List<Zayvka> getAllZyavkaByPeriod(Date b,Date en) {
        String sql = "SELECT * FROM ZAYVKA z WHERE z.DATEZ> ?1 AND z.DATEZ<?2";
        Query query = em.createNativeQuery(sql, Zayvka.class);
        query.setParameter(1, b);
        query.setParameter(2,en);
        try {
            return (List<Zayvka>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }
    
    
    
}
