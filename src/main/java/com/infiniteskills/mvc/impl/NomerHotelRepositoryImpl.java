package com.infiniteskills.mvc.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.infiniteskills.mvc.entity.Nomerhotel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.infiniteskills.mvc.repository.NomerhotelRepository;

@Service("jpaNomerhotelService")
@Transactional
@Repository
public class NomerHotelRepositoryImpl implements NomerhotelRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Nomerhotel> findAll() {
        return em.createNamedQuery("Nomerhotel.findAll").getResultList();
    }

   public List<Nomerhotel> findAllWithDetails() {
        return em.createNamedQuery("Hotel.findAllWithDetail").getResultList();
    }

    public Nomerhotel save(Nomerhotel nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Nomerhotel nomer) {
        Nomerhotel mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
     public Nomerhotel update(Nomerhotel hot) {
         return em.merge(hot);
    }

    public Nomerhotel create(Nomerhotel hot) {
       em.persist(hot);
        return hot;
    }
    
    
    }
    
    
	

