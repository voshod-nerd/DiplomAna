/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerStoimostnomera._PATH14;
import com.infiniteskills.mvc.entity.Stoimostnomera;
import com.infiniteskills.mvc.repository.StoimostNomeraRepository;
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
@RequestMapping(path = _PATH14,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerStoimostnomera {
    public static final String _PATH14 = "/reststoimostnomera";
    public static final String ITEM_PATH = "/item";
    
     private StoimostNomeraRepository uService;
     
    @Autowired(required = false)
    public void setService(StoimostNomeraRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Stoimostnomera> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stoimostnomera createU(@RequestBody Stoimostnomera zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stoimostnomera updateU(@RequestBody Stoimostnomera zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Stoimostnomera zav) {
        uService.delete(zav);
    }
}

