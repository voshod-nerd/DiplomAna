/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerReestrUslug._PATH10;
import com.infiniteskills.mvc.entity.Reestruslug;
import com.infiniteskills.mvc.repository.ReestrUslugRepository;
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
@RequestMapping(path = _PATH10,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerReestrUslug {
    public static final String _PATH10 = "/restreestuslug";
    public static final String ITEM_PATH = "/item";
    
     private ReestrUslugRepository uService;
     
    @Autowired(required = false)
    public void setService(ReestrUslugRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Reestruslug> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reestruslug createU(@RequestBody Reestruslug zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Reestruslug updateU(@RequestBody Reestruslug zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Reestruslug zav) {
        uService.delete(zav);
    }
}
