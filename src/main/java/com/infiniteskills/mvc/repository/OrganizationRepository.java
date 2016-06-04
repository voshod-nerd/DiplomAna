/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.repository;

import com.infiniteskills.mvc.entity.Organization;
import java.util.List;

/**
 *
 * @author Соколов
 */
  public interface  OrganizationRepository {
    List<Organization> findAll();

    List<Organization> findAllWithDetails();

    Organization save(Organization orf);

    void delete(Organization org);
    
    Organization update(Organization hot);

    Organization create(Organization hot);
}
