/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Typenomerhotel;
import com.infiniteskills.mvc.repository.TypeNomerHotelRepository;
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
@Service("jpaTypeNomerHotelService")
@Transactional
@Repository
public class TypeNomerHotelRepositoryImpl implements TypeNomerHotelRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<Typenomerhotel> findAll() {
      return em.createNamedQuery("Typenomerhotel.findAll").getResultList();
    }

    public List<Typenomerhotel> findAllWithDetails() {
        return em.createNamedQuery("Typenomerhotel.findAllWithDetail").getResultList();
    }

    public Typenomerhotel save(Typenomerhotel nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Typenomerhotel nomer) {
          Typenomerhotel mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Typenomerhotel create(Typenomerhotel zav) {
         em.persist(zav);
        return zav;
    }

    public Typenomerhotel update(Typenomerhotel zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Typenomerhotel find(Typenomerhotel zav) {
        return em.find(Typenomerhotel.class, zav.getId());
    }
}
