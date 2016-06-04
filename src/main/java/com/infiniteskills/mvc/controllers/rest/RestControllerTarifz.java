/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerTarifz._PATH16;
import com.infiniteskills.mvc.entity.Tarifz;
import com.infiniteskills.mvc.repository.TarifzRepository;
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
@RequestMapping(path = _PATH16,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerTarifz {
    public static final String _PATH16 = "/resttarif";
    public static final String ITEM_PATH = "/item";
    
     private TarifzRepository uService;
     
    @Autowired(required = false)
    public void setService(TarifzRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Tarifz> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tarifz createU(@RequestBody Tarifz zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Tarifz updateU(@RequestBody Tarifz zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Tarifz zav) {
        uService.delete(zav);
    }
}
