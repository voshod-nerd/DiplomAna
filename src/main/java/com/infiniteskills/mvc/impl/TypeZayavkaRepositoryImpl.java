/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Typeza;
import com.infiniteskills.mvc.repository.TypeZayavkaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Соколов
 */

@Service("jpaTypeZayavkaService")
@Transactional
@Repository
public class TypeZayavkaRepositoryImpl implements TypeZayavkaRepository {

    @PersistenceContext
    private EntityManager em;
    
    
    @Override
    public List<Typeza> findAll() {
        return em.createNamedQuery("Typeza.findAll").getResultList();
    }

    @Override
    public List<Typeza> findAllWithDetails() {
        return em.createNamedQuery("Typeza.findAllWithDetail").getResultList();
    }
    
    @Override
    public Typeza save(Typeza nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Typeza nomer) {
        Typeza mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
     public Typeza create(Typeza zav) {
         em.persist(zav);
        return zav;
    }

    public Typeza update(Typeza zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }

}
