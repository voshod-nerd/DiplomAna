/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Stoimostnomera;
import com.infiniteskills.mvc.repository.StoimostNomeraRepository;
import java.math.BigDecimal;
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
 * @author Юыху
 */
@Service("jpaStoimNomerService")
@Transactional
@Repository
public class StoimostnomeraRepositoryImpl implements StoimostNomeraRepository  {
     @PersistenceContext
    private EntityManager em;
    @Override
    public List<Stoimostnomera> findAll() {
      return em.createNamedQuery("Stoimostnomera.findAll").getResultList();
    }
    
    @Override
    public List<Stoimostnomera> findAllWithDetails() {
        return em.createNamedQuery("Stoimostnomera.findAllWithDetail").getResultList();
    }

    
    @Override
    public Stoimostnomera save(Stoimostnomera nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }
   
     @Override
    public void delete(Stoimostnomera nomer) {
          Stoimostnomera mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    
     @Override
    public Stoimostnomera create(Stoimostnomera zav) {
         em.persist(zav);
        return zav;
    }

     @Override
    public Stoimostnomera update(Stoimostnomera zav) {
      
        return em.merge(zav);
    }
    
     
    public Stoimostnomera find(Stoimostnomera zav) {
        return em.find(Stoimostnomera.class, zav.getId());
    }
    
   
    @Override
    public Stoimostnomera getSumForBronUser(String usr,int typenomer){
     String sql = "SELECT * from stoimostnomera s WHERE s.idtarif IN \n" +
"(SELECT idtarif FROM program p WHERE p.idorganization IN \n" +
"(SELECT o.ID FROM ORGANIZATION o WHERE o.iduser=?1)) AND s.idtypenomer=?2";
        Query query = em.createNativeQuery(sql,Stoimostnomera.class);
        query.setParameter(1,usr);
        query.setParameter(2,typenomer);
      
        try {
            return (Stoimostnomera) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    
    }
    
     @Override
    public Stoimostnomera getStoimNomerByNomerAndTarif(int tarif,int nomer){
     String sql = "select * from stoimostnomera s where s.idtarif=?1 and s.idtypenomer  in \n" +
"  (SELECT n.TYPENOMER FROM   NOMERHOTEL n WHERE id=?2)";
        Query query = em.createNativeQuery(sql,Stoimostnomera.class);
        query.setParameter(1,tarif);
        query.setParameter(2,nomer);
      
        try {
            return (Stoimostnomera) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    
    }
}
