/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerNomerhotel._PATH4;
import com.infiniteskills.mvc.entity.Nomerhotel;
import com.infiniteskills.mvc.repository.NomerhotelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.infiniteskills.mvc.helpclasses.Data;


/**
 *
 * @author Юыху
 */
@RestController
@RequestMapping(path = _PATH4,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerNomerhotel {
    public static final String _PATH4 = "/restnomerhotel";
    public static final String ITEM_PATH = "/item";
    
     private NomerhotelRepository uService;
     
    @Autowired(required = false)
    public void setService(NomerhotelRepository uService) {
        this.uService = uService;
    }

     @RequestMapping(method = RequestMethod.POST,value= "/items",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Nomerhotel> getFreeUnitList(@RequestBody Data zav) {
        System.out.println("Here ="+zav.getDateb());
        List<Nomerhotel> ls = uService.getFreeForReserve(zav.getDateb(), zav.getDatee(),zav.getTypenomerhotel(),zav.getIdhotel());
        System.out.println("Here ="+ls.size());
        return uService.getFreeForReserve(zav.getDateb(), zav.getDatee(),zav.getTypenomerhotel(),zav.getIdhotel());
       
    }
    
    @RequestMapping(method = RequestMethod.GET,value= "/getfree")
    public List<Nomerhotel> getFreeOnToday() {
        return uService.getFree();
       
    }
    
    
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Nomerhotel> getUnitList() {
        return uService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Nomerhotel createU(@RequestBody Nomerhotel zav) {
        return uService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Nomerhotel updateU(@RequestBody Nomerhotel zav) {
        System.out.println("I am here");
        return uService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteU(@RequestBody Nomerhotel zav) {
        uService.delete(zav);
    }
}