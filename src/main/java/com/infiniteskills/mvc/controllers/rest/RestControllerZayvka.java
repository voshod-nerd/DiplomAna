/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infiniteskills.mvc.controllers.rest;

import static com.infiniteskills.mvc.controllers.rest.RestControllerZayvka.EMPLOYEES_PATH;
import com.infiniteskills.mvc.entity.Zayvka;
import com.infiniteskills.mvc.entity.Hotel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infiniteskills.mvc.repository.ZayavkaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(path = EMPLOYEES_PATH,produces = MediaType.APPLICATION_JSON_VALUE)
public class RestControllerZayvka {
    
    public static final String EMPLOYEES_PATH = "/zav";
    public static final String ITEM_PATH = "/item";
    
    private ZayavkaRepository zayService;
     
    @Autowired(required = false)
    public void setZavService(ZayavkaRepository zayService) {
        this.zayService = zayService;
    }
    
    @RequestMapping(method = RequestMethod.POST,value= "/items",consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Zayvka> getZayvkaFromHotel(@RequestBody Hotel zav) {
        System.out.println("Here "+zav.getName());
        return zayService.getByHotel(zav.getId());
        //return zayService.findAllWithDetails();
    }
    
    
     
    
     @RequestMapping(method = RequestMethod.GET)
    public List<Zayvka> getEmployeeList() {
        return zayService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Zayvka createZayvka(@RequestBody Zayvka zav) {
        return zayService.create(zav);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Zayvka updateZayvka(@RequestBody Zayvka zav) {
        return zayService.update(zav);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            path = ITEM_PATH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteZayvka(@RequestBody Zayvka zav) {
        zayService.delete(zav);
    }
    
}
