/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.entity.Organization;
import com.infiniteskills.mvc.repository.ClientRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
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

    @Override
    public List<Client> findAll() {
        return em.createNamedQuery("Client.findAll").getResultList();
    }

    @Override
    public List<Client> findAllWithDetails() {
        return em.createNamedQuery("Client.findAllWithDetail").getResultList();
    }

    @Override
    public Client save(Client nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    @Override
    public void delete(Client nomer) {
        Client mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    @Override
    public Client create(Client zav) {
        em.persist(zav);
        return zav;
    }

    @Override
    public Client update(Client zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }

    public Client find(Client zav) {
        return em.find(Client.class, zav.getId());
    }

    @Override
    public Client findByNameAndDr(String fio, Date dr) {
        Query query = em.createNativeQuery("select * from Client u where u.fio=?1 and dr=?2", Client.class);

        query.setParameter(1, fio);
        query.setParameter(2, dr, TemporalType.DATE);
        try {

            return (Client) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }

    }

}
