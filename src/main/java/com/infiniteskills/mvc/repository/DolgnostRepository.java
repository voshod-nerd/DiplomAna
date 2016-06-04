/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Dolgnost;
import java.util.List;

/**
 *
 * @author Соколов
 */
public interface DolgnostRepository {
    List<Dolgnost> findAll();

    List<Dolgnost> findAllWithDetails();

    Dolgnost save(Dolgnost post);

    void delete(Dolgnost post); 
    
    Dolgnost update(Dolgnost zav);

    Dolgnost create(Dolgnost zav);
}
