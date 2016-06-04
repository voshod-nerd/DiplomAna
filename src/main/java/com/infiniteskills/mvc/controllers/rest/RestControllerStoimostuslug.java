/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerStoimostuslug._PATH15;
import com.infiniteskills.mvc.entity.Stoimostuslug;
import com.infiniteskills.mvc.repository.StoimostUslugRepository;
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
@RequestMapping(path = _PATH15,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerStoimostuslug {
    public static final String _PATH15 = "/reststoimostuslug";
    public static final String ITEM_PATH = "/item";
    
     private StoimostUslugRepository uService;
     
    @Autowired(required = false)
    public void setService(StoimostUslugRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Stoimostuslug> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stoimostuslug createU(@RequestBody Stoimostuslug zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stoimostuslug updateU(@RequestBody Stoimostuslug zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Stoimostuslug zav) {
        uService.delete(zav);
    }
}