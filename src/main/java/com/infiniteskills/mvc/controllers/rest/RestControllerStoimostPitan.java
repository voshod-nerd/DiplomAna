/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerStoimostPitan._PATH13;
import com.infiniteskills.mvc.entity.Stimostpitan;
import com.infiniteskills.mvc.repository.StoimostpitanRepository;
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
@RequestMapping(path = _PATH13,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerStoimostPitan {
    public static final String _PATH13 = "/reststoimostpitan";
    public static final String ITEM_PATH = "/item";
    
     private StoimostpitanRepository uService;
     
    @Autowired(required = false)
    public void setService(StoimostpitanRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Stimostpitan> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stimostpitan createU(@RequestBody Stimostpitan zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stimostpitan updateU(@RequestBody Stimostpitan zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Stimostpitan zav) {
        uService.delete(zav);
    }
}
