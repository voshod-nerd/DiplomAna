/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;





import com.infiniteskills.mvc.entity.UserRoles;
import java.util.List;


/**
 *
 * @author Юыху
 */
public interface UserRolesRepository {
    List<UserRoles> findAll();

    UserRoles update(UserRoles rab);

    UserRoles create(UserRoles rab);

    List<UserRoles> findAllWithDetails();

    UserRoles save(UserRoles rab);

    void delete(UserRoles rab);
}
