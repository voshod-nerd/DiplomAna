/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;


import com.infiniteskills.mvc.entity.Employee;
import java.util.List;


/**
 *
 * @author Юыху
 */
public interface UserRepository {
    List<Employee> findAll();

    Employee update(Employee rab);

    Employee create(Employee rab);

    List<Employee> findAllWithDetails();

    Employee save(Employee rab);

    void delete(Employee rab); 
    Employee findUserByLogin(String login);
    List<String> getAllRoles();
}
