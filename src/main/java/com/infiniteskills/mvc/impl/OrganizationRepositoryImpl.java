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

/**
 *
 * @author �������
 */
@Service("jpaOrganizationService")
@Transactional
@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Organization> findAll() {
        return em.createNamedQuery("Organization.findAll").getResultList();
    }

    public List<Organization> findAllWithDetails() {
        return em.createNamedQuery("Organization.findAllWithDetail").getResultList();
    }

    public Organization save(Organization nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Organization nomer) {
        Organization mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
    
    public Organization update(Organization hot) {
         return em.merge(hot);
    }

    public Organization create(Organization hot) {
       em.persist(hot);
        return hot;
    }
    

}
