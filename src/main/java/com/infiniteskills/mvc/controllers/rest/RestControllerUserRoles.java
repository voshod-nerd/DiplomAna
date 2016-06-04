/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;


import static com.infiniteskills.mvc.controllers.rest.RestControllerUserRoles._PATH18;
import com.infiniteskills.mvc.entity.UserRoles;
import com.infiniteskills.mvc.repository.UserRolesRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Юыху
 */
@RestController
@RequestMapping(path = _PATH18,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerUserRoles {
    public static final String _PATH18 = "/resttypeuser";
    public static final String ITEM_PATH = "/item";
    
     private UserRolesRepository uService;
     
    @Autowired(required = false)
    public void setService(UserRolesRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<UserRoles> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserRoles createU(@RequestBody UserRoles zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserRoles updateU(@RequestBody UserRoles zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody UserRoles zav) {
        uService.delete(zav);
    }
}
