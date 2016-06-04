/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerClient._PATH2;
import com.infiniteskills.mvc.entity.Client;
import com.infiniteskills.mvc.repository.ClientRepository;
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
@RequestMapping(path = _PATH2,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerClient {
    public static final String _PATH2 = "/restclient";
    public static final String ITEM_PATH = "/item";
    
     private ClientRepository uService;
     
    @Autowired(required = false)
    public void setService(ClientRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Client> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client createU(@RequestBody Client zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client updateU(@RequestBody Client zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Client zav) {
        uService.delete(zav);
    }
    
    
}

