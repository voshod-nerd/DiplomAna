/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;


import com.infiniteskills.mvc.entity.User;
import java.util.List;


/**
 *
 * @author Юыху
 */
public interface UserRepository {
    List<User> findAll();

    User update(User rab);

    User create(User rab);

    List<User> findAllWithDetails();

    User save(User rab);

    void delete(User rab); 
    User findUserByLogin(String login);
  
}
