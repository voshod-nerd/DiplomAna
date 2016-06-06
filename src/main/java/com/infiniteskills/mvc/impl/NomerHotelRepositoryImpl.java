package com.infiniteskills.mvc.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import javax.persistence.TypedQuery;
import com.infiniteskills.mvc.entity.Nomerhotel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.infiniteskills.mvc.repository.NomerhotelRepository;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

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
        em.persist(hot);
        return hot;
    }

    @Override
    public Nomerhotel getFreeForReserve(Date db, Date de, String typenomer, String hotel) {
       
        String sql = "SELECT * FROM Nomerhotel n WHERE id NOT IN (SELECT b.idnomer FROM Bron b WHERE b.dateb>=?1 AND b.datee<=?1) \n"
                + "AND ID NOT IN (SELECT p.idnomer FROM progivanie p WHERE p.datein>=?1 AND p.dateout<=?2) AND n.READY=1 AND n.TYPENOMER=?3 and idgostin=?4";
        Query query = em.createNativeQuery(sql, Nomerhotel.class);
        query.setParameter(1, db);
        query.setParameter(2, de);
        query.setParameter(3, typenomer);
        query.setParameter(4, hotel);
        try {
            return (Nomerhotel) query.getSingleResult();
        } catch (NonUniqueResultException | NoResultException e) {
            return null;
        }
    }

}
