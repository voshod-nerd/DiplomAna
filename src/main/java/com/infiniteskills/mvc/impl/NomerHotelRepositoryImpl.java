package com.infiniteskills.mvc.impl;

import com.infiniteskills.mvc.entity.Hotel;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.infiniteskills.mvc.entity.Nomerhotel;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.infiniteskills.mvc.repository.NomerhotelRepository;
import java.util.Date;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Service("jpaNomerhotelService")
@Transactional
@Repository
public class NomerHotelRepositoryImpl implements NomerhotelRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Nomerhotel> findAll() {
        return em.createNamedQuery("Nomerhotel.findAll").getResultList();
    }

    @Override
    public List<Nomerhotel> findAllWithDetails() {
        return em.createNamedQuery("Hotel.findAllWithDetail").getResultList();
    }

    @Override
    public Nomerhotel save(Nomerhotel nomer) {
        if (nomer.getId() == null) {
            em.persist(nomer);
        } else {
            em.merge(nomer);
        }
        return nomer;
    }

    @Override
    public void delete(Nomerhotel nomer) {
        Nomerhotel mergedDep = em.merge(nomer);
        em.remove(mergedDep);
    }

    @Override
    public Nomerhotel update(Nomerhotel hot) {
        return em.merge(hot);
    }

    @Override
    public Nomerhotel create(Nomerhotel hot) {
        hot.setReady(Boolean.TRUE);
        em.persist(hot);
        return hot;
    }

    @Override
    public List<Nomerhotel> getFreeForReserve(Date db, Date de, int typenomer, int hotel) {
       
        
        
       String sql = "SELECT * FROM Nomerhotel n WHERE id NOT IN (SELECT b.idnomer FROM Bron b WHERE b.dateb>=?1 AND b.datee<=?2) AND ID NOT IN (SELECT p.idnomer FROM progivanie p WHERE p.datein>= ?1 AND p.dateout<= ?2) AND n.READY=TRUE AND n.TYPENOMER=?3 and idgostin=?4";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, db,TemporalType.DATE);
        query.setParameter(2, de,TemporalType.DATE);
        query.setParameter(3, typenomer);
        query.setParameter(4, hotel);
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    @Override
    public List<Nomerhotel> getFree() {
       String sql = "SELECT * FROM NOMERHOTEL n WHERE n.ID NOT IN (SELECT p.idnomer FROM progivanie p WHERE p.dateout>NOW())\n" +
"AND n.ID NOT in (SELECT b.idnomer FROM bron b WHERE b.datee>NOW())";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
     @Override
    public List<Nomerhotel> getFreeByHotel(Hotel hotel) {
       String sql = "SELECT * FROM NOMERHOTEL n WHERE n.ID NOT IN (SELECT p.idnomer FROM progivanie p WHERE p.dateout>NOW())\n" +
"AND n.ID NOT in (SELECT b.idnomer FROM bron b WHERE b.datee>NOW()) AND n.IDGOSTIN=?1 and n.READY=TRUE";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, hotel.getId());
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    @Override
    public List<Nomerhotel> getBronByHotel(Hotel hotel) {
       String sql = "SELECT * FROM NOMERHOTEL n WHERE \n" +
"n.ID  in (SELECT b.idnomer FROM bron b WHERE b.datee>=NOW()) AND n.IDGOSTIN=?1 and n.READY=TRUE";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, hotel.getId());
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    @Override
    public List<Nomerhotel> getRemontByHotel(Hotel hotel) {
       String sql = "SELECT * FROM NOMERHOTEL n WHERE  n.READY=FALSE AND n.IDGOSTIN=?1";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, hotel.getId());
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
    
       @Override
    public List<Nomerhotel> getProgByHotel(Hotel hotel) {
       String sql = "SELECT * FROM NOMERHOTEL n WHERE n.ID  IN (SELECT p.idnomer FROM progivanie p WHERE p.dateout>NOW())\n" +
" AND n.IDGOSTIN=?1";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, hotel.getId());
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    
    
    
    
    
    @Override
    public Nomerhotel findById(int id) {
     
   TypedQuery<Nomerhotel> query = em.createQuery("select u from Nomerhotel u where u.id=?1", Nomerhotel.class);
      
		query.setParameter(1, id);
		try {
			return query.getSingleResult();
		} catch (NonUniqueResultException | NoResultException e) {
			return null;
		}
    
    
    }
    
    
     @Override
    public List<Nomerhotel> getNomerHotelByHotel(String hotel) {
       String sql = "SELECT * FROM NOMERHOTEL n WHERE n.IDGOSTIN IN (SELECT id FROM HOTEL h WHERE h.ID=?1) ";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, hotel);
        try {
            return (List<Nomerhotel>) query.getResultList();
        } catch (NonUniqueResultException | NoResultException e) {
            ///System.out.println("error");
            return null;
        }
    }
    
    

}
