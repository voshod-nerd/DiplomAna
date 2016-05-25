/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Client;
import java.util.List;

/**
 *
 * @author Юыху
 */
public interface ClientRepository {
     List<Client> findAll();

    Client update(Client zav);

    Client create(Client zav);

    List<Client> findAllWithDetails();

    Client save(Client cl);

    void delete(Client cl);
}
