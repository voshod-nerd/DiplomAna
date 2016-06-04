/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.repository.ClientRepository;
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
@Service("jpaClientService")
@Transactional
@Repository
public class ClientRepositoryImpl implements ClientRepository {
   @PersistenceContext
    private EntityManager em;
    
    public List<Client> findAll() {
      return em.createNamedQuery("Zayvka.findAll").getResultList();
    }

    public List<Client> findAllWithDetails() {
        return em.createNamedQuery("Zayvka.findAllWithDetail").getResultList();
    }

    public Client save(Client nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Client nomer) {
          Client mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Client create(Client zav) {
         em.persist(zav);
        return zav;
    }

    public Client update(Client zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Client find(Client zav) {
        return em.find(Client.class, zav.getId());
    }
}
