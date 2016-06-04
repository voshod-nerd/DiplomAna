/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;


import com.infiniteskills.mvc.entity.Employee;
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
    
    public List<Employee> findAll() {
      return em.createNamedQuery("Employee.findAll").getResultList();
    }

    public List<Employee> findAllWithDetails() {
        return em.createNamedQuery("Employee.findAllWithDetail").getResultList();
    }

    public Employee save(Employee nomer) {
          if (nomer.getUsername() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Employee nomer) {
          Employee mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    public Employee create(Employee zav) {
         em.persist(zav);
        return zav;
    }

    public Employee update(Employee zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
    
    public Employee find(Employee zav) {
        return em.find(Employee.class, zav.getUsername());
    }
    
    @Override
    public Employee findUserByLogin(String login) {
                
		TypedQuery<Employee> query = em.createQuery("select u from Employee u where u.username=?1", Employee.class);
		query.setParameter(1, login);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
	}
    
    @Override
   public  List<String> getAllRoles() 
    {
        System.out.println("1f");
    TypedQuery<String> query = em.createQuery("select role from Employee", String.class);
      
		//query.setParameter(1, login);
		try {
			return query.getResultList();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
    
    
    
    }
    
    
}
