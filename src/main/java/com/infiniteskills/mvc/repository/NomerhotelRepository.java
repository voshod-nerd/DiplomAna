package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Hotel;
import java.util.List;



import com.infiniteskills.mvc.entity.Nomerhotel;
import java.util.Date;


;

public interface NomerhotelRepository {

    List<Nomerhotel> findAll();

    List<Nomerhotel> findAllWithDetails();

    Nomerhotel save(Nomerhotel nomer);

    void delete(Nomerhotel nomer);
    
     Nomerhotel update(Nomerhotel hot);

    Nomerhotel create(Nomerhotel hot);
    
    List<Nomerhotel> getFreeForReserve(Date db,Date de,int typenomer,int hotel);
    List<Nomerhotel> getFree();
    Nomerhotel findById(int id);
    List<Nomerhotel> getNomerHotelByHotel(String hotel);
    List<Nomerhotel> getProgByHotel(Hotel hotel);
    List<Nomerhotel> getBronByHotel(Hotel hotel);
    List<Nomerhotel> getFreeByHotel(Hotel hotel);
    List<Nomerhotel> getRemontByHotel(Hotel hotel);
    
}
