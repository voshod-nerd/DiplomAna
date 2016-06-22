/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Progivanie;
import com.infiniteskills.mvc.entity.Reestruslug;
import com.infiniteskills.mvc.entity.Stoimostnomera;
import com.infiniteskills.mvc.entity.Stoimostuslug;
import com.infiniteskills.mvc.entity.Tarifz;
import com.infiniteskills.mvc.entity.Typenomerhotel;
import com.infiniteskills.mvc.repository.ProgivanieRepository;
import com.infiniteskills.mvc.repository.ReestrUslugRepository;
import com.infiniteskills.mvc.repository.StoimostNomeraRepository;
import com.infiniteskills.mvc.repository.StoimostUslugRepository;
import com.infiniteskills.mvc.repository.TarifzRepository;
import com.infiniteskills.mvc.repository.TypeNomerHotelRepository;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Юыху
 */
@Service("jpaProgivService")
@Transactional
@Repository
public class ProgivanieRepositoryImpl implements ProgivanieRepository {
    @PersistenceContext
    private EntityManager em;
    private ProgivanieRepository uService;
    private  ReestrUslugRepository  ReestService;
    private StoimostUslugRepository uslugService;
    private TarifzRepository tarifService;
    private TypeNomerHotelRepository typenomerService;
    private StoimostNomeraRepository stoimService;
    
    @Autowired(required = false)
    public void setServiceProg(ProgivanieRepository uService) {
        this.uService = uService;
    }
    
     @Autowired(required = false)
    public void setServiceNomer(StoimostNomeraRepository uService) {
        this.stoimService = uService;
    }
    
    
    @Autowired(required = false)
    public void setServiceTypenomer(TypeNomerHotelRepository uService) {
        this.typenomerService = uService;
    }
    
     @Autowired(required = false)
    public void setServiceReest(ReestrUslugRepository uService) {
        this.ReestService = uService;
    }
    
     @Autowired(required = false)
    public void setServiceTarif(TarifzRepository uService) {
        this.tarifService = uService;
    }
    
    
     @Autowired(required = false)
    public void setServiceUslug(StoimostUslugRepository uService) {
        this.uslugService = uService;
    }
    
    
    
    @Override
    public List<Progivanie> findAll() {
      return em.createNamedQuery("Progivanie.findAll").getResultList();
    }

    
    @Override
    public List<Progivanie> findAllWithDetails() {
        return em.createNamedQuery("Progivanie.findAllWithDetail").getResultList();
    }

    
    @Override
    public Progivanie save(Progivanie nomer) {
          if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }
    
    

    @Override
    public void delete(Progivanie nomer) {
         Progivanie mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    
    @Override
    public Progivanie create(Progivanie zav) { 
        Collection<Reestruslug> listUslug= ReestService.getListUslugByIdClient(zav.getIdclient());
        System.out.println("1 step");
        BigDecimal dopsum = new BigDecimal(0.0);
        for (Reestruslug uslug : listUslug)
        {
          Stoimostuslug temp= uslugService.getListUslugByIdUslug(uslug.getIduslug());
        if (temp==null)  continue;
        dopsum.add(temp.getSumma()); 
        }
        System.out.println("2 step");
        zav.setDopusl(dopsum);
        
        Tarifz tarif= tarifService.getTarifByClient(zav.getIdclient());
        System.out.println(tarif.getName());
        System.out.println(zav.getIdnomer());
        Typenomerhotel typenomer=typenomerService.getTypeNomerByIdnomer(zav.getIdnomer());
        Stoimostnomera temp=stoimService.getStoimNomerByNomerAndTarif(tarif.getId(), zav.getIdnomer().getId());
  
        zav.setIdstoimostnomer(temp);
        System.out.println("3 step");
        
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(zav.getDateout());
        cal2.setTime(zav.getDatein());
        int days = (int)((cal1.getTimeInMillis()-cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        System.out.println(days);
        
        BigDecimal totalSum = new BigDecimal(0.0);
       
         totalSum=totalSum.add(temp.getSumma());
        
        BigDecimal dayDec = new BigDecimal(days);
        totalSum=totalSum.multiply(dayDec);
        
        
       
        
       
        System.out.println("4 step");
        System.out.println(totalSum.floatValue());
        
        totalSum=totalSum.add(dopsum);
       
        zav.setTotalsum(totalSum);
        zav.setClosed(0);
         em.persist(zav);
        return zav;
    }

    
    @Override
    public Progivanie update(Progivanie zav) {
        Collection<Reestruslug> listUslug= ReestService.getListUslugByIdClient(zav.getIdclient());
        System.out.println("1 step");
        BigDecimal dopsum = new BigDecimal(0.0);
        for (Reestruslug uslug : listUslug)
        {
          Stoimostuslug temp= uslugService.getListUslugByIdUslug(uslug.getIduslug());
        if (temp==null)  continue;
        dopsum.add(temp.getSumma()); 
        }
        System.out.println("2 step");
        zav.setDopusl(dopsum);
        
        Tarifz tarif= tarifService.getTarifByClient(zav.getIdclient());
        System.out.println(tarif.getName());
        System.out.println(zav.getIdnomer());
        Typenomerhotel typenomer=typenomerService.getTypeNomerByIdnomer(zav.getIdnomer());
        Stoimostnomera temp=stoimService.getStoimNomerByNomerAndTarif(tarif.getId(), zav.getIdnomer().getId());
  
        zav.setIdstoimostnomer(temp);
        System.out.println("3 step");
        
       
       
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        cal1.setTime(zav.getDateout());
        cal2.setTime(zav.getDatein());
        int days = (int)((cal1.getTimeInMillis()-cal2.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        System.out.println(days);
        
        BigDecimal totalSum = new BigDecimal(0.0);
       
         totalSum=totalSum.add(temp.getSumma());
        
        BigDecimal dayDec = new BigDecimal(days);
        totalSum=totalSum.multiply(dayDec);
        
        
       
        
       
        System.out.println("4 step");
        System.out.println(totalSum.floatValue());
        
        totalSum=totalSum.add(dopsum);
      
        zav.setTotalsum(totalSum);
        return em.merge(zav);
    }
    
   
    public Progivanie find(Progivanie zav) {
        return em.find(Progivanie.class, zav.getId());
    }
    
    
    @Override
     public List<Progivanie> getCurrentProg(){
     Query query = em.createNativeQuery("SELECT * FROM progivanie p WHERE p.closed=0", Progivanie.class);
		
		try {
			return (List<Progivanie>)query.getResultList();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
        
    }
    
    
    
    public Progivanie findProgivById(String id){
     Query query = em.createNativeQuery("select * from progivanie u where u.id=?1", Progivanie.class);
		query.setParameter(1, id);
		try {
			return (Progivanie)query.getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
        
    }
    
      @Override
     public List<Progivanie> findProgivByHotel(String hotel){
     Query query = em.createNativeQuery("SELECT * FROM progivanie p WHERE p.idnomer IN \n" +
"(SELECT id FROM NOMERHOTEL n  WHERE n.IDGOSTIN=?1 ) AND p.closed=0", Progivanie.class);
		query.setParameter(1, hotel);
		try {
			return (List<Progivanie>)query.getResultList();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
        
    }

    @Override
     public List<Progivanie> ProgivByPeriod(Date b,Date en){
     Query query = em.createNativeQuery("SELECT * FROM progivanie p WHERE p.datein>?1 AND p.datein<?2", Progivanie.class);
		query.setParameter(1,b);
                query.setParameter(2,en);
		try {
			return (List<Progivanie>)query.getResultList();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
        
    }
    
    
}
