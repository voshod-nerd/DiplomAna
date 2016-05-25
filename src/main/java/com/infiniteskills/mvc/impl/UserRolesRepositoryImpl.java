/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;


import com.infiniteskills.mvc.entity.UserRoles;
import com.infiniteskills.mvc.repository.UserRolesRepository;
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

@Service("jpaUserRolesService")
@Transactional
@Repository
public class UserRolesRepositoryImpl implements UserRolesRepository {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<UserRoles> findAll() {
      return em.createNamedQuery("Typeuser.findAll").getResultList();
    }
    
    @Override
    public List<UserRoles> findAllWithDetails() {
        return em.createNamedQuery("Typeuser.findAllWithDetail").getResultList();
    }

    public UserRoles save(UserRoles nomer) {
        
          if (nomer.getUserRoleId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(UserRoles nomer) {
          UserRoles mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public UserRoles create(UserRoles zav) {
         em.persist(zav);
        return zav;
    }

    public UserRoles update(UserRoles zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public UserRoles find(UserRoles zav) {
        return em.find(UserRoles.class, zav.getUserRoleId());
    } 
}
