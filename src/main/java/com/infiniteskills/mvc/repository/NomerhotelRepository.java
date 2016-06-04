package com.infiniteskills.mvc.repository;

import java.util.List;



import com.infiniteskills.mvc.entity.Nomerhotel;


;

public interface NomerhotelRepository {

    List<Nomerhotel> findAll();

    List<Nomerhotel> findAllWithDetails();

    Nomerhotel save(Nomerhotel nomer);

    void delete(Nomerhotel nomer);
    
     Nomerhotel update(Nomerhotel hot);

    Nomerhotel create(Nomerhotel hot);
}
