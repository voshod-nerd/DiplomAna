/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Stoimostuslug;
import com.infiniteskills.mvc.repository.StoimostUslugRepository;
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
@Service("jpaStUslugService")
@Transactional
@Repository
public class StoimostuslugRepositoryImpl implements StoimostUslugRepository {
     @PersistenceContext
    private EntityManager em;
    
    public List< Stoimostuslug> findAll() {
      return em.createNamedQuery("Stoimostuslug.findAll").getResultList();
    }

    public List< Stoimostuslug> findAllWithDetails() {
        return em.createNamedQuery("Stoimostuslug.findAllWithDetail").getResultList();
    }

    public  Stoimostuslug save( Stoimostuslug nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete( Stoimostuslug nomer) {
           Stoimostuslug mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public  Stoimostuslug create( Stoimostuslug zav) {
         em.persist(zav);
        return zav;
    }

    public  Stoimostuslug update( Stoimostuslug zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public  Stoimostuslug find( Stoimostuslug zav) {
        return em.find( Stoimostuslug.class, zav.getId());
    }
}
