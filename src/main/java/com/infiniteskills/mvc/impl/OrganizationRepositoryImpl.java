/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Organization;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infiniteskills.mvc.repository.OrganizationRepository;
import javax.persistence.TypedQuery;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

/**
 *
 * @author Соколов
 */
@Service("jpaOrganizationService")
@Transactional
@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    @PersistenceContext
    private EntityManager em;
    
     @Override
    public List<Organization> findAll() {
        return em.createNamedQuery("Organization.findAll").getResultList();
    }
    
     @Override
    public List<Organization> findAllWithDetails() {
        return em.createNamedQuery("Organization.findAllWithDetail").getResultList();
    }

    
     @Override
    public Organization save(Organization nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }
    
     @Override
    public void delete(Organization nomer) {
        Organization mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
     @Override
    public Organization update(Organization hot) {
         return em.merge(hot);
    }

     @Override 
    public Organization create(Organization hot) {
       em.persist(hot);
        return hot;
    }
    
    @Override
    public Organization findOrganizationByName(String name){
     TypedQuery<Organization> query = em.createQuery("select u from Organization u where u.name=?1", Organization.class);
      
		query.setParameter(1, name);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
        
    }
    
    
    @Override
    public Organization findOrganizationByUsername(String usr){
     Query query = em.createNativeQuery("select * from Organization u where u.iduser=?1", Organization.class);
      
		query.setParameter(1, usr);
		try {
			return (Organization)query.getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
        
    }
    

}
