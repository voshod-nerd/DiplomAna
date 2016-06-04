/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Program;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.infiniteskills.mvc.repository.ProgramRepository;

/**
 *
 * @author Соколов
 */
@Service("jpaProgramService")
@Transactional
@Repository
public class ProgramRepositoryImpl implements ProgramRepository {

    
   @PersistenceContext
    private EntityManager em;

    public List<Program> findAll() {
          return em.createNamedQuery("Program.findAll").getResultList();
    }

    public List<Program> findAllWithDetails() {
        return em.createNamedQuery("Program.findAllWithDetail").getResultList();
    }

    public Program save(Program nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    public void delete(Program nomer) {
        Program mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }
 
     public Program create(Program zav) {
         em.persist(zav);
        return zav;
    }

    public Program update(Program zav) {
        //int version = find(zav).getVersion();
        //Zayvka.setVersion(version);
        return em.merge(zav);
    }
 
    
   
    
}
