/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;


import com.infiniteskills.mvc.entity.User;
import com.infiniteskills.mvc.repository.UserRepository;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Юыху
 */
@Service("jpaUserService")
@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<User> findAll() {
      return em.createNamedQuery("User.findAll").getResultList();
    }

    public List<User> findAllWithDetails() {
        return em.createNamedQuery("User.findAllWithDetail").getResultList();
    }

    public User save(User nomer) {
          if (nomer.getUsername() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(User nomer) {
          User mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public User create(User zav) {
         em.persist(zav);
        return zav;
    }

    public User update(User zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public User find(User zav) {
        return em.find(User.class, zav.getUsername());
    }
    
    @Override
    public User findUserByLogin(String login) {
		TypedQuery<User> query = em.createQuery("select u from User u where u.login=?1", User.class);
		query.setParameter(1, login);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
	}
    
    
}
