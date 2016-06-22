/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Bron;
import com.infiniteskills.mvc.repository.BronRepository;
import java.util.Date;
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
@Service("jpaBronService")
@Transactional
@Repository
public class BronRepositoryImpl implements BronRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Bron> findAll() {
        return em.createNamedQuery("Bron.findAll").getResultList();
    }

    @Override
    public List<Bron> findAllWithDetails() {
        return em.createNamedQuery("Bron.findAllWithDetail").getResultList();
    }

    @Override
    public Bron save(Bron nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    @Override
    public void delete(Bron nomer) {
        Bron mergedDep = em.find(Bron.class, nomer.getId());
        em.remove(mergedDep);
    }

    @Override
    public Bron create(Bron zav) {
        zav.setClosed(0);
        em.persist(zav);
        return zav;
    }

    @Override
    public Bron update(Bron zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }

    public Bron find(Bron zav) {
        return em.find(Bron.class, zav.getId());
    }

    @Override
    public List<Bron> getBronByIdOrg(int idorg) {

        String sql = "SELECT * from bron where idorg=?1 and datee>now()";
        Query query = em.createNativeQuery(sql, Bron.class);
        query.setParameter(1, idorg);
        try {
            return (List<Bron>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    @Override
    public List<Bron> getBronByHotel(String idhotel) {

        String sql = "SELECT * FROM bron b WHERE b.idnomer IN (SELECT id FROM NOMERHOTEL n WHERE n.IDGOSTIN=?1) AND b.datee>NOW() ";
        Query query = em.createNativeQuery(sql, Bron.class);
        query.setParameter(1, idhotel);
        try {
            return (List<Bron>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
    @Override
    public List<Bron> getBronByPeriod(Date b,Date en) {

        String sql = "SELECT * FROM bron WHERE dateb>= ?1 AND dateb<=?2";
        Query query = em.createNativeQuery(sql, Bron.class);
        query.setParameter(1, b);
        query.setParameter(2, en);
        try {
            return (List<Bron>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
}
