/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Hotel;
import com.infiniteskills.mvc.repository.HotelRepository;

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
@Service("jpaHotelService")
@Transactional
@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Hotel> findAll() {
        return em.createNamedQuery("Hotel.findAll").getResultList();
    }

    public List<Hotel> findAllWithDetails() {
        return em.createNamedQuery("Hotel.findAllWithDetail").getResultList();
    }

    public Hotel save(Hotel nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Hotel nomer) {
        Hotel mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Hotel update(Hotel hot) {
         return em.merge(hot);
    }

    public Hotel create(Hotel hot) {
       em.persist(hot);
        return hot;
    }
}
