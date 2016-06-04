/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerGrafik._PATH33;
import com.infiniteskills.mvc.entity.Grafik;
import com.infiniteskills.mvc.repository.GrafikRepository;
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
@RequestMapping(path = _PATH33,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerGrafik {
      public static final String _PATH33 = "/restgrafik";
    public static final String ITEM_PATH = "/item";
    
     private GrafikRepository uService;
     
    @Autowired(required = false)
    public void setService(GrafikRepository uService) {
        this.uService = uService;
    }
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Grafik> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Grafik createU(@RequestBody Grafik zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Grafik updateU(@RequestBody Grafik zav) {
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Grafik zav) {
        uService.delete(zav);
    }
}
